#include <vector>

int square_sum(const std::vector<int>& numbers)
{
    int total = 0;
    for (int i : numbers) total += i*i;
    return total;
}