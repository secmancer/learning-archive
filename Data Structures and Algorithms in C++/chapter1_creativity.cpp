#include <iostream>
#include <string>
#include <vector>
#include <math.h>

bool isEven(std::vector<int>& nums) {
    for (int i = 0; i < nums.size(); i++)
        for (int j = 1; j < nums.size(); j++)
            if ((nums[i] + nums[j]) % 2 == 0)
                return true;
    return false;
}

bool isDifferent(std::vector<int>& nums) {
    for (int i = 0; i < nums.size(); i++)
        for (int j = 0; j < nums.size(); j++)
            if (nums[i] == nums[j])
                return false;
    return true;
}

void printOddValues(std::vector<int>& nums) {
    for (int i = 0; i < nums.size(); i++)
        if (nums[i] % 2 != 0)
            std::cout << nums[i] << std::endl;
}

std::vector<double> addVectors(std::vector<double>& a, std::vector<double>& b) {
    std::vector<double> c;
    if (a.size() == b.size()) {
        for (int i = 0; i < a.size(); i++)
            c.push_back(a[i] + b[i]);
    }
    return c;
}

int gcd(int a, int b) {
    while (a % b != 0) {
        int temp = a % b;
        a = b;
        b = temp;
    }
    return b;
}