import base64

COOKIE = "HmYkBwozJw4WNyAAFyB1VUcqOE1JZjUIBis7ABdmbU1GIjEJAyIxTRg="
DEFAULT = "eyJzaG93cGFzc3dvcmQiPT4ibm8iLCAiYmdjb2xvciI9PiIjZmZmZmZmIn0="
KEY = b'eDWo'
PAYLOAD = '{"showpassword":"yes", "bgcolor":"#000000"}'

def encode_to_base64(encoded_str):
    return base64.b64encode(encoded_str)

def decrypt_from_base64(encoded_str):
    return base64.b64decode(encoded_str)

def decrypt_cookie():
    decrypted_data = decrypt_from_base64(COOKIE)
    print("Decrypted data:", decrypted_data)
    
def encode_default():
    encoded_default = encode_to_base64(DEFAULT)
    print("Base64 encoded default string:", encoded_default)
    
def encode_xor(string, key):
    return bytes([string[i] ^ key[i % len(key)] for i in range(len(string))])

def derive_key():
    decoded_cookie = decrypt_from_base64(COOKIE)
    decoded_default = decrypt_from_base64(DEFAULT)
    
    print("Decoded COOKIE:", decoded_cookie)
    print("Decoded DEFAULT:", decoded_default)
    
    xor_result = encode_xor(decoded_cookie, decoded_default)
    print("XOR Result:", xor_result)
    
    final_payload = encode_xor(PAYLOAD.encode(), KEY)
    payload_cookie = encode_to_base64(final_payload)
    print("Final Payload Cookie:", payload_cookie)

def main():
    derive_key()
    
if __name__ == "__main__":
    main()