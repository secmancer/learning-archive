#include <math.h>
#include <iostream>

std::string get_middle(std::string input) 
{
    std::string::size_type index = input.length() % 2 == 0;
    std::string::size_type size = input.length() / 2;
    return input.substr(size - index, index + 1);
}