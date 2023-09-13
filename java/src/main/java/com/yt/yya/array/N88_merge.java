package com.yt.yya.array;

public class N88_merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1;
        int index = nums1.length - 1;

        while (p1 >= 0 && p2 >= 0) {
            int a = nums1[p1];
            int b = nums2[p2];
            if (b >= a) {
                nums1[index] = b;
                p2--;
            } else {
                nums1[index] = a;
                p1--;
            }

            index--;
        }

        while (p1 >= 0) {
            nums1[index--] = nums1[p1--];
        }

        while (p2 >= 0) {
            nums1[index--] = nums2[p2--];
        }
    }
}
