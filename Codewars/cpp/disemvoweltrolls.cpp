# include <string>
# include <vector>
# include <algorithm>

std::string disemvowel(const std::string& str) {
   std::string answer;
   for (char i : str)
     if (i == 'a' || i == 'A' || 
         i == 'e' || i == 'E' || 
         i == 'i' || i == 'I' ||
         i == 'o' || i == 'O' ||
         i == 'u' || i == 'U') continue;
     else answer += i;
   return answer;
}