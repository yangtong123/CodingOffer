package com.yt.yya.array;

public class N1011_shipWithinDays {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int right = 0;

        for (int w : weights) {
            left = Math.max(left, w);
            right += w;
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (f(weights, mid) <= days) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public int f(int[] weights, int x) {
        int day = 1;
        int remain = x;

        for (int w : weights) {
            if (remain >= w) {
                remain -= w;
            } else {
                day++;
                remain = x - w;
            }
        }

        return day;
    }
}
