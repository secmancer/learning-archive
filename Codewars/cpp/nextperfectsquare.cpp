#include <math.h>

long int findNextSquare(long int sq) {
  long int factor = sqrt(sq);
  if (sq % factor == 0)
     return pow(factor + 1, 2);
  return -1;
}
