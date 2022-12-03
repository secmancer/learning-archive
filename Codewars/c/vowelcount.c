#include <stddef.h>
#include <string.h>

size_t get_count(const char *s)
{
    int total = 0;
    unsigned long i;
    for (i = 0; i < strlen(s); i++) {
        if (s[i] == 'a' || s[i] == 'e' || s[i] == 'i' || s[i] == 'o' || s[i] == 'u') total +=1;
    }
    return total;
}