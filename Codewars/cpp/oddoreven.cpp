#include <string>
#include <vector>

std::string odd_or_even(const std::vector<int> &arr)
{
    int total = 0;
    for (int num : arr) total += num;
    return (total % 2 == 0) ? "even" : "odd";
}