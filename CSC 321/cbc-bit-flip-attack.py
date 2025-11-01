from Crypto.Cipher import AES
from Crypto.Util.Padding import pad, unpad
from Crypto.Random import get_random_bytes

##############################################################################
# VARIABLES
##############################################################################

# BLOCK SIZE
# Since we are using AES-128-CBC, the block size is set to 16 bytes (which expands to 128 bits).
BLOCK_SIZE = 16

# KEY
# Generate a random 16-byte (128-bit) key for AES-128
KEY = get_random_bytes(BLOCK_SIZE)

# IV
# Generate a random 16-byte (128-bit) initialization vector for AES
IV = get_random_bytes(BLOCK_SIZE)

# STRING PREFIX
# String added to the beginning of an arbitrary input before encryption
STRING_PREFIX = b"userid=456;userdata="

# STRING SUFFIX
# String added to the end of an arbitrary input before encryption
STRING_SUFFIX = b";session_id=31337"

##############################################################################
# FUNCTIONS
##############################################################################

# CBC Encryption code from Task 1
def CBC_Encrypt(text: bytes) -> bytes:
    cipher = AES.new(KEY, AES.MODE_ECB)
    ciphertext = bytearray() 

    for i in range(0, len(text), BLOCK_SIZE):
        #CBC XORing
        if i == 0:
            block = text[i:i+BLOCK_SIZE]
            xored_block = bytes(x ^ y for x, y in zip(block, IV))

        else:
            block = text[i:i+BLOCK_SIZE]
            xored_block = bytes(x ^ y for x, y in zip(block, prev))

        encrypted_block = cipher.encrypt(xored_block) 
        prev = encrypted_block
        ciphertext += encrypted_block
    return ciphertext 

# ECB Encryption code from Task 1
def ECB_Encrypt(text: bytes) -> bytes:
    cipher = AES.new(KEY, AES.MODE_ECB)
    ciphertext = bytearray() 

    for i in range(0, len(text), BLOCK_SIZE):
        block = text[i:i+BLOCK_SIZE]
        encrypted_block = cipher.encrypt(block) 
        ciphertext += encrypted_block
    return ciphertext 


# Encodes ';' and '=' characters in the input by replacing them with their URL-encoded equivalents.
def url_encode(input: str) -> str:
    return input.replace(";", "%3B").replace("=", "%3D")

# Take the input string, URL encode necessary characters, pad it, and encrypt it using our AES-128-CBC implementation.
def submit(input_text: str) -> bytes:
    # First, URL encoded the input string, and then convert to bytes
    encoded_input = url_encode(input_text).encode()
    
    # Construct the full plaintext
    full_plaintext = STRING_PREFIX + encoded_input + STRING_SUFFIX
    
    # Pad our full plaintext with PKCS#7 padding
    padded_plaintext = pad(full_plaintext, BLOCK_SIZE)
    
    # Encrypt the padded plaintext using AES-128-CBC
    ciphertext = CBC_Encrypt(padded_plaintext)
    return ciphertext

# Decrypt the ciphertext and verify plaintext contains the substring ";admin=true;".
def verify(cipher_text: bytes) -> bool:
    # Decrypt the ciphertext using AES-128-CBC
    cipher = AES.new(KEY, AES.MODE_CBC, IV)
    
    # Let's handle potential padding errors gracefully
    try:
        
        # Decrypt the ciphertext
        decrypted = cipher.decrypt(cipher_text)
        
        # Unpad the decrypted plaintext
        unpadded = unpad(decrypted, BLOCK_SIZE)
        
        # Check if the unpadded plaintext contains the substring ";admin=true;"
        return b";admin=true;" in unpadded
    
    # Oops! Something went wrong (likely bad padding)
    except (ValueError, KeyError):
        return False
    

# Perform a CBC bit-flipping attack to make verify() true.
def cbc_bitflip_attack() -> bytes:
    # This is our target string that we want to inject
    target = b";admin=true;"
    
    # Length of the target
    target_length = len(target)
    
    # Original byte we want to flip (the first byte of the target)
    original_byte = ord('x')  # ASCII value of 'x'
    
    # Get the length of the prefix
    prefix_length = len(STRING_PREFIX)
    
    # Calculate padding length to align 'x' at the start of a block
    padding_length = (BLOCK_SIZE - (prefix_length % BLOCK_SIZE)) % BLOCK_SIZE
    
    # Check to see if we need to add an extra block
    # This is necessary so that we don't flip the IV block by mistake (since the IV is one minus the first block)
    if (prefix_length + padding_length) % BLOCK_SIZE == 0:
        padding_length += BLOCK_SIZE
    
    # Create our block of 'x's
    block_of_x = b'x' * (padding_length + target_length)
    blocks = block_of_x.decode('utf-8')
    
    # Encrypt the block of 'x's using submit()
    ciphertext = bytearray(submit(blocks))

    # Calculate the position of the block we want to modify
    target_index = (prefix_length + padding_length) // BLOCK_SIZE

    # Let's note the previous block (the one we will modify)
    prev_block = (target_index - 1) * BLOCK_SIZE
    
    # Now, let's flip the necessary bits in the previous block
    for i in range(target_length):
        # Get our desired byte from the target
        desired_byte = target[i]
        
        # Calculate the byte we need to XOR with in the previous block
        byte_to_xor = original_byte ^ desired_byte
        
        # Perform the bit flip in the previous block
        ciphertext[prev_block + i] ^= byte_to_xor
        
    # Return the manipulated ciphertext
    return bytes(ciphertext)
        

# Main function
def main():
    # First, let's print out the key and IV for reference
    print("KEY:", KEY.hex())
    print("IV:", IV.hex())
    print("")
    
    # Payload
    PAYLOAD = "xxx;admin=true;yyy"
    
    print("Original Payload:", PAYLOAD)
    print("")
    print("Running submit()...")

    # Encrypt the payload using submit()
    ciphertext = submit(PAYLOAD)
    print("Ciphertext:", ciphertext.hex())
    print("")
    
    print("Running verify()...")
    
    # Verify the ciphertext using verify()
    # We didn't manipulate the ciphertext yet, so this should return False
    is_admin = verify(ciphertext)
    print("Is admin true? (NON-BIT-FLIPPING)", is_admin)
    print("")
    
    # Now, let's perform the CBC bit-flipping attack
    print("Running cbc_bitflip_attack()...")
    manipulated_ciphertext = cbc_bitflip_attack()
    print("Manipulated Ciphertext:", manipulated_ciphertext.hex())
    print("")
    
    # Let's verify the manipulated ciphertext
    is_admin_after_attack = verify(manipulated_ciphertext)
    print("Is admin true? (AFTER BIT-FLIPPING)", is_admin_after_attack)
    print("")
    

# Driver code
if __name__ == "__main__":
    main()