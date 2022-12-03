#include <map>
#include <string>

std::map<char, unsigned> count(const std::string& string) {
    std::map<char, unsigned> letters;
    if (string.length() == 0) return {};
    for (char letter : string) ++letters[letter];
    return letters;
}