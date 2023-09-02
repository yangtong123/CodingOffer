package com.yt.yya.array;

public class N1109_corpFlightBookings {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] ans = new int[n];
        for (int[] val : bookings) {
            int from = val[0];
            int to = val[1];
            int v = val[2];

            ans[from - 1] += v;
            if (to < n) {
                ans[to] -= v;
            }
        }

        for (int i = 1; i < n; i++) {
            ans[i] += ans[i - 1];
        }

        return ans;
    }
}
