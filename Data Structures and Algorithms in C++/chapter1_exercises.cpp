#include <iostream>
#include <string>
#include <vector>
#include <math.h>

/* Class Based Solutions */

struct Pair {
    int first;
    double second;
};

class Flower {
public:
    Flower();
    ~Flower();

    Flower::Flower(std::string flowerName, int numPedals, float flowerPrice) {
        name = flowerName;
        numOfPedals = numPedals;
        price = flowerPrice;
    }

    void setName(std::string flowerName) { name = flowerName; }  
    std::string getName() { return name; }

    void setNumOfPedals(int numPedals) { numPedals = numOfPedals; }
    int getNumOfPedals() { return numOfPedals; }

    void setPrice(int flowerPrice) { price = flowerPrice; }
    float getPrice() { return price; }

private:
    std::string name;
    int numOfPedals;
    float price;
};

/* Function Based Solutions  */

int smallSum(int n) {
    int total = 0;
    for (int i = 0; i < n; i++) total += i;
    return total;
}

bool isMultiple(long m, long n) {
    return (n % m == 0) ? true : false;
}

bool isTwoPower(int i) {
    return (i % 2 == 0) ? true : false;
}

int smallOddSum(int n) {
    int total = 0;
    for (int i = 0; i < n; i++) if (i % 2 != 0) total += i;
    return total;
}

int numOfTwo(double x) {
    int num = 0;
    while (x < 2) {
        x /= 2;
        num++;
    }
    return num;
}
