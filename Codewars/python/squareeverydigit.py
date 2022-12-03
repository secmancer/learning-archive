def square_digits(num):
    strnum = [int(x) for x in str(num)]
    temp = []
    for i in strnum:
        temp.append(i**2)
    answer = int("".join(map(str, temp)))
    return answer
