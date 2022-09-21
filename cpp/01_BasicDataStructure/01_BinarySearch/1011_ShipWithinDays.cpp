//
// Created by yangtong on 2022/9/21.
//

#include <vector>
using namespace std;

/**
 * https://leetcode.cn/problems/capacity-to-ship-packages-within-d-days/
 */
class ShipWithinDays {
public:
    int shipWithinDays(vector<int>& weights, int days) {
        int left = 0;
        int right = 1;
        for (const auto &item: weights) {
            left = max(item, left);
            right += item;
        }

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (f(weights, mid) <= days) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

private:
    int f(vector<int>& weights, int x) {
        int days = 0;
        int cap = x;

        for (const auto &item: weights) {
            if (cap >= item) {
                cap -= item;
            } else {
                days++;
                cap = x - item;
            }
        }

        return days;
    }
};


