//
// Created by yangtong on 2022/9/3.
//

/**
 * https://leetcode.cn/problems/ugly-number-iii/
 */
class Solution {
public:
    int nthUglyNumber(int n, int a, int b, int c) {
        int left = 0, right = (int) 2e9;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (f(mid, a, b, c) < n) {
                left = mid + 1;
            } else{
                right = mid - 1;
            }
        }

        return left;
    }

    long f(int num, int a, int b, int c) {
        long setA = num / a;
        long setB = num / b;
        long setC = num / c;

        long setAB = num / lcm(a, b);
        long setAC = num / lcm(a, c);
        long setBC = num / lcm(b, c);
        long setABC = num / lcm(lcm(a, b), c);

        return setA + setB + setC - setAB - setAC - setBC + setABC;
    }

    // 计算最小公倍数
    long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }

    // 计算最大公约数（辗转相除算法/欧几里得算法）
    long gcd(long a, long b) {
        if (a < b) {
            gcd(b, a);
        }

        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }
};

int main() {
    int n = 4;
    int a = 2;
    int b = 3;
    int c = 4;

    Solution solution;

    solution.nthUglyNumber(n, a, b, c);
}

