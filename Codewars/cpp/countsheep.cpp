#include <vector>

using namespace std; 

int count_sheep(vector<bool> arr) 
{
  int total = 0;
  for (bool sheep : arr) {
    if (sheep == true) total +=1;
    else continue;
  }
  return total;
}


