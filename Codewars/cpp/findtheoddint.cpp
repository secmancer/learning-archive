#include <vector>
#include <map>

int findOdd(const std::vector<int>& numbers){    
    std::map<int,int> numCount;
    for (int i : numbers) {
      ++numCount[i];
    }
    for (std::pair<int,int> element : numCount) {
       int value = element.second;
       if (value % 2 != 0) return element.first;
    }
    return 0;
}