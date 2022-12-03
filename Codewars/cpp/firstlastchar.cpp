#include <string>

using namespace std; 

string sliceString (string str )
{
  string result = str.substr(1, str.size() - 2);
  return result;  
}