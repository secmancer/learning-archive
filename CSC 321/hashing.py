import Crypto.Hash.SHA256 as SHA256
import random

# ----------------------------------

# Takes a string and returns its SHA-256 hash as a hexadecimal string.
def hash_string(input: str) -> str:
    hash_obj = SHA256.new(input.encode('utf-8'))
    return hash_obj.hexdigest()

# Calculates the Hamming distance between two hash strings at the bit level.
# https://en.wikipedia.org/wiki/Hamming_distance 
def hamming_distance(bits1: bytes, bits2: bytes) -> int:
    # Both bit strings must be of equal length
    if len(bits1) != len(bits2):
        raise ValueError("Input byte strings must be of equal length")
    
    return sum((b1 ^ b2).bit_count() for b1, b2 in zip(bits1, bits2))

# Flip a single bit in the input string at the specified index.
def flip_bit(input: bytes, index: int) -> bytes:
    # Convert our index to byte and bit positions
    byte_index = index // 8
    bit_index = index % 8
    
    # Create a mask to flip the specific bit
    mask = 1 << (7 - bit_index)
    
    # Flip the bit using XOR and return the modified bytes
    bytes_modified = bytearray(input)
    bytes_modified[byte_index] ^= mask
    return bytes_modified

# ----------------------------------

# Part A function
def part_a():
    print("PART A")
    while True:
        user_input = input("Enter text to get hash (enter q to quit): ")
        if user_input.lower() == 'q':
            break
        print(f"Hash: {hash_string(user_input)}")

# Part B function
def part_b():
    print("PART B")
    
    # Array of example strings (we'll do it 4 times)
    strings = [b"Hello, World!", b"CSC 321", b"Trick or Treat", b"Hashing is fun!"]
    
    # Loop through each string
    for original in strings:
        # Create two byte strings that differ by one bit (flip bit at random position)
        bits_1 = original
        bits_2 = flip_bit(bits_1, random.randint(0, len(bits_1) * 8 - 1)) # Flip a random bit
        
        # Print original and modified byte strings
        print(f"Original Bytes: {bits_1}")
        print(f"Modified Bytes: {bits_2}")
        
        # Calculate Hamming distance between them
        distance = hamming_distance(bits_1, bits_2)
        print(f"Hamming Distance: {distance}")
    
        # Verify it's in fact 1
        assert distance == 1, "Hamming distance should be 1 for this test case"
        
        # We passed the check, let's put them into strings form first
        bits_1_string = bits_1.decode('utf-8', errors='ignore')
        bits_2_string = bits_2.decode('utf-8', errors='ignore')
        
        # Now let's hash both and print the results
        hash_1 = hash_string(bits_1_string)
        hash_2 = hash_string(bits_2_string)
        print(f"Hash 1: {hash_1}")
        print(f"Hash 2: {hash_2}")
        
        # Calculate Hamming distance between the two hashes
        hash_distance = hamming_distance(bytes.fromhex(hash_1), bytes.fromhex(hash_2))
        print(f"Hamming Distance between Hashes: {hash_distance}")
        print("\n")
        
    # Pause before exiting
    input("Press Enter to exit...")

# Main function
def main():
    part_a()
    part_b()
    
# Driver code
if __name__ == "__main__":
    main()