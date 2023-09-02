package com.yt.yya.array;

import java.lang.reflect.Array;
import java.util.Arrays;

public class N1094_carPooling {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] cap = new int[1001];
        for (int[] t : trips) {
            int num = t[0];
            int from = t[1];
            int to = t[2];

            cap[from] += num;
            cap[to] -= num;
        }

        int sum = 0;
        for (int v : cap) {
            sum += v;
            if (sum > capacity) {
                return false;
            }
        }

        return true;
    }
}
