//
// Created by yangtong on 2022/9/21.
//
#include <iostream>
#include <vector>
#include "1201_nthUglyNumber.cpp"
#include "1011_ShipWithinDays.cpp"

using namespace std;

void processNthUglyNumber() {
    int n = 4;
    int a = 2;
    int b = 3;
    int c = 4;

    NthUglyNumber uglyNumber;
    int result = uglyNumber.nthUglyNumber(n, a, b, c);
    cout << "result: " << result << endl;
}

void processShipWithinDays() {
    vector<int> weight {1,2,3,4,5,6,7,8,9,10};
    int days = 5;

    ShipWithinDays obj;
    int result = obj.shipWithinDays(weight, days);
    cout << "result: " << result << endl;
}

int main() {
//    processNthUglyNumber();
    processShipWithinDays();
}