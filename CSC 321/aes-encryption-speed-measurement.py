import subprocess, sys, re, shutil, json
from pathlib import Path
from collections import defaultdict

import pandas as pd
import matplotlib.pyplot as plt

# Output directory
OUTPUT_DIRECTORY = Path("output")
OUTPUT_DIRECTORY.mkdir(exist_ok=True)

# AES key sizes
AES_KEY_SIZES = ["aes-128-cbc", "aes-192-cbc", "aes-256-cbc"]

# RSA key sizes
RSA_KEY_SIZES = [512, 1024, 2048, 4096]

def run_command(command):
    return subprocess.run(command, capture_output=True, text=True)

def parse_aes_output(output, size):
    line = None
    for output_line in output.splitlines():
        if output_line.strip().startswith(size):
            line = output_line
            break
        
    if not line:
        return []
    
    aes_output_values = re.findall(r"(\d+(?:\.\d+)?)k", line)
    aes_block_sizes = [16, 64, 256, 1024, 8192, 16384][:len(aes_output_values)]
    aes_data = [{"size": size, "block_size": b, "throughput_Bps": float(v) * 1000.0}
            for b, v in zip(aes_block_sizes, aes_output_values)]
    
    return aes_data

def parse_rsa_output(output, bits):
    sign = verify = None
    pattern_any = re.compile(rf"(?:^|\s)rsa\s*{bits}(?:\s+bits)?", re.IGNORECASE)

    for line in output.splitlines():
        if pattern_any.search(line):
            floats = re.findall(r"(\d+(?:\.\d+)?)", line)
            # We need at least two floats; take the last two as ops/s
            if len(floats) >= 2:
                sign, verify = map(float, floats[-2:])
                break
    return sign, verify

def run_aes_tests():
    aes_results = []
    for size in AES_KEY_SIZES:
        output = run_command(["openssl", "speed", size])
        aes_results.extend(parse_aes_output(output.stdout, size))
    data_frame = pd.DataFrame(aes_results)
    data_frame.to_csv(OUTPUT_DIRECTORY / "aes_results.csv", index=False)
    return data_frame
    
def run_rsa_tests():
    rsa_results = []
    for bits in RSA_KEY_SIZES:
        proc = run_command(["openssl", "speed", f"rsa{bits}"])
        # Some builds write to stderr; combine them
        full_output = (proc.stdout or "") + "\n" + (proc.stderr or "")
        rsa_sign, rsa_verify = parse_rsa_output(full_output, bits)

        if rsa_sign is not None and rsa_verify is not None:
            rsa_key_bytes = bits // 8
            rsa_results.append({
                "key_bits": bits,
                "sign_ops_per_s": rsa_sign,
                "verify_ops_per_s": rsa_verify,
                "sign_Bps": rsa_sign * rsa_key_bytes,
                "verify_Bps": rsa_verify * rsa_key_bytes,
                # Using verify≈encrypt and sign≈decrypt (public/private) throughput proxies:
                "encrypt_Bps": rsa_verify * rsa_key_bytes,
                "decrypt_Bps": rsa_sign * rsa_key_bytes
            })
        else:
            # Optional: help you see what didn’t match
            print(f"[warn] Could not parse RSA results for {bits} bits.\n"
                  f"Sample output line(s):\n{full_output}")

    df = pd.DataFrame(rsa_results)
    df.to_csv(OUTPUT_DIRECTORY / "rsa_results.csv", index=False)
    return df

def plot_aes(df):
    plt.figure()
    for size, subset in df.groupby("size"):
        subset = subset.sort_values("block_size")
        plt.plot(subset["block_size"], subset["throughput_Bps"] / 1e6, marker="o", label=size)
    plt.title("AES Throughput vs Block Size")
    plt.xlabel("Block size (bytes)")
    plt.ylabel("Throughput (MB/s)")
    plt.legend()
    plt.grid(True, linestyle="--", alpha=0.5)
    plt.tight_layout()
    plt.savefig(OUTPUT_DIRECTORY / "aes_throughput.png", dpi=150)

def plot_rsa(df):
    plt.figure()
    df = df.sort_values("key_bits")
    # base curves
    plt.plot(df["key_bits"], df["sign_Bps"]   / 1e3, marker="o", label="sign (kB/s)",   zorder=3)
    plt.plot(df["key_bits"], df["verify_Bps"] / 1e3, marker="o", label="verify (kB/s)", zorder=3)

    # “proxy” curves (identical to the above) as dashed + lighter
    plt.plot(df["key_bits"], df["decrypt_Bps"] / 1e3, marker="x", linestyle="--", alpha=0.6,
             label="decrypt ≈ sign (kB/s)")
    plt.plot(df["key_bits"], df["encrypt_Bps"] / 1e3, marker="x", linestyle="--", alpha=0.6,
             label="encrypt ≈ verify (kB/s)")

    plt.title("RSA Throughput vs Key Size")
    plt.xlabel("RSA key size (bits)")
    plt.ylabel("Throughput (kB/s)")
    plt.legend()
    plt.grid(True, linestyle="--", alpha=0.5)
    plt.tight_layout()
    plt.savefig(OUTPUT_DIRECTORY / "rsa_throughput.png", dpi=150)


def main():
    print("Running AES tests...")
    aes_data_frame = run_aes_tests()
    print("AES tests completed.")
    
    print("Running RSA tests...")
    rsa_data_frame = run_rsa_tests()
    print("RSA tests completed.")
    
    print("Generating plots...")
    plot_aes(aes_data_frame)
    plot_rsa(rsa_data_frame)

if __name__ == "__main__":
    main()