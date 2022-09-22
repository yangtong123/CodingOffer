//
// Created by yangtong on 2022/9/22.
//

#include "vector"

using namespace std;

class MinEatingSpeed {
public:
    int minEatingSpeed(vector<int>& piles, int h) {
        int left = 1;
        int right = 1000000000 + 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (f(piles, mid) <= h) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    int f(const vector<int>& piles, int x) {
        int hours = 0;
        for (auto &item: piles) {
            hours += item / x;
            hours += (item % x == 0 ? 0 : 1);
        }

        return hours;
    }
};