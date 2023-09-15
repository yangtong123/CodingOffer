package com.yt.yya.array;

import java.util.Arrays;

public class N274_HIndex {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);

        int h = 0, i = citations.length - 1;

        while (i >= 0 && citations[i] > h) {
            h++;
            i--;
        }

        return h;
    }
}
