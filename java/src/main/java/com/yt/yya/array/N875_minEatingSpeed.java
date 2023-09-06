package com.yt.yya.array;

public class N875_minEatingSpeed {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 1000000000;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (f(piles, mid) <= h) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private int f(int[] piles, int x) {
        int cnt = 0;
        for (int pile : piles) {
            cnt += Math.ceil(pile / (double) x);
        }

        return cnt;
    }

    public static void main(String[] args) {
        int[] input = {332484035,524908576,855865114,632922376,222257295,690155293,112677673,679580077,337406589,290818316,877337160,901728858,679284947,688210097,692137887,718203285,629455728,941802184};
        int h = 823855818;

        N875_minEatingSpeed obj = new N875_minEatingSpeed();
        obj.minEatingSpeed(input, h);
    }
}
