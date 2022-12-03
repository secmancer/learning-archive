#include <math.h>

class Solution {
public:
    bool isPerfectSquare(int num) {
        int factor = pow(num, 0.5);
        return pow(num, 0.5) == factor ? true : false;
    }
};