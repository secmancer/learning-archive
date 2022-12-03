def is_square(n):
    if (n < 0):
        return False
    if (n == 0):
        return True
    square = n**0.5
    if (n % square == 0):
        return True
    return False