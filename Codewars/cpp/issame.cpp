#include <vector>
#include <map>
#include <iostream>
#include <algorithm>

class Same {
public :
    static bool comp(std::vector<int>&a, std::vector<int>&b) {
       std::map <int, int> originalCount;
       std::map <int, int> copyCount;
       
       for (auto i : b) ++originalCount[i];
       for (auto h : a) ++copyCount[h*h];
    
      
       return (originalCount == copyCount) ? true : false;
    }
};