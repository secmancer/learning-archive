#include <string>
#include <cctype>

using namespace std;

class Solution {
public:
    string toLowerCase(string str) {
        string result = str;
        for (auto x : str) result += tolower(str[x]);
        return str;
    }
};