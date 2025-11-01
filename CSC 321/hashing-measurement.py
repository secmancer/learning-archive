from Crypto.Hash import SHA256
from random import choice
import time, matplotlib.pyplot as plt, numpy as np

# ----------------------------------

plot1_data_points = dict()
plot2_data_points = dict()

# Add a data point to our dictionary
def add_data_point(bits: int, time_taken: float, data_points: dict):
    if bits not in data_points:
        data_points[bits] = []
    data_points[bits].append(time_taken)

# ----------------------------------

# Generate a random string of a given length
def generate_string_from_length(length: int) -> str:
    characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"
    return ''.join(choice(characters) for _ in range(length))

# Computes a SHA-256 hash, but truncates it at a certain bit length
def generate_truncated_hash(input: str, length: int) -> bytes:
    # Generate our hash
    hash = SHA256.new(input.encode()).digest()
    
    # Convert ouyr length from bits to bytes
    byte_length = length // 8
    
    # Truncate and return the hash
    return hash[:byte_length]

# Find a hash collision for a given input
# Uses the birthday paradox to find a collision
# Returns the colliding string and its truncated hash
def find_hash_collision(input: str, truncate_length: int) -> tuple[str, str, int]:
    # Init our dictionary to store seen hashes
    hashes = {}
    counter = 0
    
    # Loop until we find a collision
    while True:
        # Generate a new random string (same length as input)
        rand_str = generate_string_from_length(len(input))
        
        # Generate the truncated hash
        truncated_hash = generate_truncated_hash(rand_str, truncate_length)
        
        # Check if we've seen this hash before
        if truncated_hash in hashes:
            return (rand_str, truncated_hash.hex(), counter)

        # If not, then we know it's new, so store it
        hashes[truncated_hash] = rand_str
        counter += 1

# ----------------------------------

# Example data processing code
def example_data_processing():
    # Generate input strings and find their collisions
    for bits in range(8, 40, 2):
        # Perform the magic
        print("Bits:", bits)
        test_string = generate_string_from_length(40)
        print("Generated String:", test_string)
        print("Truncated Hash of Original String:", generate_truncated_hash(test_string, bits).hex())
        time_begin = time.perf_counter()
        string, hash, counter = find_hash_collision(test_string, bits)
        time_end = time.perf_counter()
        print("Truncated Hash:", hash)
        print("Colliding String:", string)
        print("Number of Attempts:", counter)
        print(f"Time Taken (seconds): {time_end - time_begin:0.3f}")
        print("\n")
        add_data_point(bits, round(time_end - time_begin, 3), plot1_data_points)
        add_data_point(bits, counter, plot2_data_points)
        
    print("Data processing complete.")

# Main data processing code
def main_data_processing():
    # Generate input strings and find their collisions
    # Starts at 8 bits and goes up to 50 bits by multiples of 2
    for bits in range(8, 52, 2):
        # Perform the magic
        print("Bits:", bits)
        test_string = generate_string_from_length(40)
        print("Generated String:", test_string)
        print("Truncated Hash of Original String:", generate_truncated_hash(test_string, bits).hex())
        time_begin = time.perf_counter()
        string, hash, counter = find_hash_collision(test_string, bits)
        time_end = time.perf_counter()
        print("Truncated Hash:", hash)
        print("Colliding String:", string)
        print(f"Time Taken (seconds): {time_end - time_begin:0.3f}")
        print("\n")
        add_data_point(bits, round(time_end - time_begin, 3), plot1_data_points)
        add_data_point(bits, counter, plot2_data_points)
        
    print("Data processing complete.")

# Main function
def main():    
    # Do the data processing
    # example_data_processing()
    main_data_processing()
    
    # Plotting the results for the first plot
    fig_1, ax_1 = plt.subplots()
    bits_1 = plot1_data_points.keys()
    times_1 = plot1_data_points.values()
    ax_1.grid(True)
    ax_1.set_xlabel('Digest Size (bits)')
    ax_1.set_ylabel('Time to Collision (seconds)')
    ax_1.plot(bits_1, times_1, marker='o')
    
    # Plotting the results for the second plot
    fig_2, ax_2 = plt.subplots()
    bits_2 = plot2_data_points.keys()
    times_2 = plot2_data_points.values()
    ax_2.grid(True)
    ax_2.set_xlabel('Digest Size (bits)')
    ax_2.set_ylabel('Number of Attempts to Collision (count)')
    ax_2.plot(bits_2, times_2, marker='o')
    
    # Show the plots
    plt.show()


# Driver code
if __name__ == "__main__":
    main()