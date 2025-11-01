from Crypto.Util.number import getPrime
import time

# Finds GCD using the Extended Euclidean Algorithm
def extended_gcd(a: int, b: int) -> tuple:
    # First, handle base case
    if a == 0:
        return (b, 0, 1)
    else:
        # Recursive case
        gcd, x1, y1 = extended_gcd(b % a, a)
        return (gcd, y1 - (b // a) * x1, x1)
    
# Finds modular inverse of a under modulo m
def mod_inverse(a: int, m: int) -> int:
    # Use e_gcd to find the inverse
    gcd, x, _ = extended_gcd(a, m)
    
    # If gcd is not 1, then the modular inverse does not exist
    if gcd != 1:
        raise Exception('Modular inverse does not exist')
    else:
        return x % m
    
# Find the GCD of two numbers (non extended)
def gcd(a: int, b: int) -> int:
    while b:
        a, b = b, a % b
    return a

# RSA class
class RSA:
    # Values
    e = 65537
    p = None
    q = None
    n = None
    d = None
    phi = None
    
    # Generate a RSA key pair
    def generate_keys(self, bits: int) -> tuple:
        # Get our two primes p and q
        self.p = getPrime(bits)
        self.q = getPrime(bits)
        
        # Ensure p and q are distinct
        while self.p == self.q:
            self.q = getPrime(bits)
        
        # Calculate n
        self.n = self.p * self.q
        
        # Calculate phi
        self.phi = (self.p - 1) * (self.q - 1)
        
        # Calculate d
        self.d = mod_inverse(self.e, self.phi)
        
        # Create our public and private keys
        public_key = (self.e, self.n)
        private_key = (self.d, self.n)
        
        # Return the keys
        return (public_key, private_key)
        
    # RSA Encryption
    def encrypt(self, m: int) -> int:
        # Calculate ciphertext and return it
        ciphertext = pow(m, self.e, self.n)
        return ciphertext

    # RSA Decryption
    def decrypt(self, c: int) -> int:
        # Calculate plaintext and return it
        plaintext = pow(c, self.d, self.n)
        return plaintext

# ASCII to hex conversion
def ascii_to_hex(message: str) -> str:
    return message.encode('ascii').hex()

# Hex to ASCII conversion
def hex_to_ascii(hex_string: str) -> str:
    return bytes.fromhex(hex_string).decode('ascii')

# Hex to int conversion
def hex_to_int(hex_string: str) -> int:
    return int(hex_string, 16)

# Int to hex conversion
def int_to_hex(message_int: int) -> str:
    return hex(message_int)[2:]

# Boilerplate variables
alice, bob, mallory = "[ALICE]", "[BOB]", "[MALLORY]"

# Print functions
def alice_print(msg: str):
    print(f"{alice} {msg}")
    
def bob_print(msg: str):
    print(f"{bob} {msg}")
    
def mallory_print(msg: str):
    print(f"{mallory} {msg}")
    
# Main function
def main():
    print("Starting Task 3 Part 1....")
    time.sleep(1)
    
    # Initialize RSA for Alice and Bob
    alice_print("Generating RSA keys...")
    alice_rsa = RSA()
    alice_public, alice_private = alice_rsa.generate_keys(512)
    alice_print("Keys generated.")
    time.sleep(1)
    
    # Bob asks for Alice's public key
    bob_print("Requesting Alice's public key...")
    time.sleep(1)
    bob_print(f"Received Alice's public key: {alice_public[0]}")
    time.sleep(1)
    
    # Bob picks a random x in Z_n* (basically, 1 < x < n and gcd(x, n) = 1)
    bob_print("Thanks! Now picking a random x in Z_n*...")
    n_bytes = (alice_public[1].bit_length() + 7) // 8
    while True:
        x = int.from_bytes(getPrime(n_bytes).to_bytes(n_bytes, 'big'), 'big') % alice_public[1]
        if 1 < x < alice_public[1] and gcd(x, alice_public[1]) == 1:
            break
        
    bob_print(f"Picked x = {x}")
    time.sleep(1)
    
    # Bob finds y = x^e mod n
    bob_print("Calculating y = x^e mod n...")
    y = RSA().encrypt(x)
    bob_print(f"Calculated y")
    time.sleep(1)
    
    # Bob sends y to Alice
    bob_print("Sending y to Alice...")
    time.sleep(1)
    alice_print(f"Received y from Bob.")
    time.sleep(1)
    
    # Alice decrypts y to get x
    alice_print("Decrypting y to get x...")
    x_recovered = alice_rsa.decrypt(y)
    alice_print(f"Decrypted y to get x = {x_recovered}")
    time.sleep(1)
    
    # Alice sends an encrypted message to Bob
    message = b"Hi Bob!"
    alice_print(f"Encrypting message '{message.decode()}'")
    message_hex = ascii_to_hex(message.decode())
    message_int = hex_to_int(message_hex)
    ciphertext_int = RSA().encrypt(message_int)
    ciphertext_hex = int_to_hex(ciphertext_int)
    alice_print(f"Ciphertext (hex): {ciphertext_hex[0:30]}... (truncated)")
    alice_print(f"Sending encrypted message to Bob...")
    time.sleep(1)
    
    # Bob decrypts the message
    bob_print("Decrypting the message...")
    decrypted_int = alice_rsa.decrypt(ciphertext_int)
    decrypted_hex = int_to_hex(decrypted_int)
    decrypted_message = hex_to_ascii(decrypted_hex)
    bob_print(f"Decrypted message: '{decrypted_message}'")
    time.sleep(1)
    
    # Bob sends a message to Alice
    bob_message = b"Hello Alice!"
    bob_print(f"Encrypting message '{bob_message.decode()}'")
    bob_message_hex = ascii_to_hex(bob_message.decode())
    bob_message_int = hex_to_int(bob_message_hex)
    bob_ciphertext_int = RSA().encrypt(bob_message_int)
    bob_ciphertext_hex = int_to_hex(bob_ciphertext_int)
    bob_print(f"Ciphertext (hex): {bob_ciphertext_hex[0:30]}... (truncated)")
    bob_print(f"Sending encrypted message to Alice...")
    time.sleep(1)
    
    # Alice decrypts the message
    alice_print("Decrypting the message...")
    alice_decrypted_int = alice_rsa.decrypt(bob_ciphertext_int)
    alice_decrypted_hex = int_to_hex(alice_decrypted_int)
    alice_decrypted_message = hex_to_ascii(alice_decrypted_hex)
    alice_print(f"Decrypted message: '{alice_decrypted_message}'")
    time.sleep(1)
    
    print("Task 3 Part 1 complete.")
    
    time.sleep(2)
    print("Starting Task 3 Part 2....")
    
    # Alice re-sends her public key to Bob
    time.sleep(1)
    alice_print("Here's my public key again.")
    alice_print(f"Public Key: {alice_public}")
    time.sleep(1)
    
    # Bob plans on sending a message to Alice
    bob_message2 = b"Are you there Alice?"
    bob_print(f"Encrypting message '{bob_message2.decode()}'")
    bob_message2_hex = ascii_to_hex(bob_message2.decode())
    bob_message2_int = hex_to_int(bob_message2_hex)
    bob_ciphertext2_int = RSA().encrypt(bob_message2_int)
    bob_ciphertext2_hex = int_to_hex(bob_ciphertext2_int)
    bob_print(f"Ciphertext (hex): {bob_ciphertext2_hex[0:30]}... (truncated)")
    bob_print(f"Sending encrypted message to Alice...")
    time.sleep(1)
    
    # Mallory intercepts the message
    mallory_print("Intercepted a message from Bob to Alice!")
    mallory_print(f"Ciphertext (hex): {bob_ciphertext2_hex[0:30]}... (truncated)")
    time.sleep(1)
    
    # Find c' so that we can decrypt and find the message
    mallory_print("Calculating c' = c * x^e mod n...")
    x_e = pow(x, alice_public[0], alice_public[1])
    # c' = c * x^e mod n
    # c_prime = (bob_ciphertext2_int * x_e) % alice_public[1]
    c_prime = (2 * bob_ciphertext2_int * x_e) % alice_public[1]
    mallory_print(f"Calculated c'")
    time.sleep(1)
    
    # Mallory sends c' to Alice
    mallory_print("Sending c' to Alice...")
    time.sleep(1)
    alice_print("Received a message from Bob (actually Mallory)...")
    time.sleep(1)
    
    # Alice decrypts c' to get m'
    alice_print("Decrypting c' to get m'...")
    m_prime_int = alice_rsa.decrypt(c_prime)
    alice_print(f"Decrypted c' to get m'")
    time.sleep(1)
    
    # Alice sends m' back to Bob (actually Mallory)
    alice_print("Sending m' back to Bob...")
    time.sleep(1)
    mallory_print("Received m' from Alice!")
    time.sleep(1)
    
    # Mallory calculates m = m' * x^(-1) mod n
    mallory_print("Calculating m = m' * x^(-1) mod n...")
    x_inv = mod_inverse(x, alice_public[1])
    m_int = (m_prime_int * x_inv) % alice_public[1]
    mallory_print(f"Calculated m")
    time.sleep(1)
    
    # Convert m back to ASCII
    m_hex = int_to_hex(m_int)
    m_ascii = hex_to_ascii(m_hex)
    mallory_print(f"Decrypted message: '{m_ascii}'")
    time.sleep(1)
    
    # Send a fake message to Alice
    fake_message = b"It's Mallory. I am in your walls :)"
    mallory_print(f"Encrypting fake message '{fake_message.decode()}'")
    fake_message_hex = ascii_to_hex(fake_message.decode())
    fake_message_int = hex_to_int(fake_message_hex)
    fake_ciphertext_int = RSA().encrypt(fake_message_int)
    fake_ciphertext_hex = int_to_hex(fake_ciphertext_int)
    mallory_print(f"Ciphertext (hex): {fake_ciphertext_hex[0:30]}... (truncated)")
    mallory_print(f"Sending fake encrypted message to Alice...")
    time.sleep(1)
    
    # Alice decrypts the fake message
    alice_print("Decrypting the fake message...")
    alice_fake_decrypted_int = alice_rsa.decrypt(fake_ciphertext_int)
    alice_fake_decrypted_hex = int_to_hex(alice_fake_decrypted_int)
    alice_fake_decrypted_message = hex_to_ascii(alice_fake_decrypted_hex)
    alice_print(f"Decrypted message: '{alice_fake_decrypted_message}'")
    time.sleep(1)
    
    # Final statement
    time.sleep(1)
    alice_print("AAAHHHHHHHHH!")
    mallory_print("Your cookie jar is mine now!")
    time.sleep(1)
    
    # Also, show how Mallory can create a valid signature for the fake message
    # Where m_3 = m_1 * m_2
    mallory_print("Creating a valid signature for the fake message...")
    m1_int = hex_to_int(ascii_to_hex("Hi Bob!"))
    m2_int = hex_to_int(ascii_to_hex("Hi Alice!"))
    m3_int = (m1_int * m2_int) % alice_public[1]
    # Based on: sign(m, d) = m^d mod n
    s1_int = pow(m1_int, alice_rsa.d, alice_public[1])
    s2_int = pow(m2_int, alice_rsa.d, alice_public[1])
    s3_int = (s1_int * s2_int) % alice_public[1]
    mallory_print(f"Created signature s3 for message m3.")
    time.sleep(1)
    
    # Verify the signature
    mallory_print("Verifying the signature...")
    v_int = pow(s3_int, alice_public[0], alice_public[1])
    if v_int == m3_int:
        mallory_print("Signature verified successfully!")
    else:
        mallory_print("Signature verification failed.")
    time.sleep(1)
    
    print("Task 3 Part 2 complete.")

# Driver code
if __name__ == "__main__":
    main()