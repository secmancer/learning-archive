def gimme(input_array):
    sorted_array = sorted(input_array)
    middle = sorted_array[1]
    if (sorted_array[0] < middle < sorted_array[2]):
        numIndex = input_array.index(sorted_array[1])
        return numIndex;
    return -1;