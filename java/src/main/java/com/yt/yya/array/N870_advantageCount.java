package com.yt.yya.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class N870_advantageCount {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        PriorityQueue<int[]> maxQueue = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);

        for (int i = 0; i < nums2.length; i++) {
            maxQueue.offer(new int[] {i, nums2[i]});
        }
        Arrays.sort(nums1);

        int left = 0, right = nums1.length - 1;
        int[] res = new int[nums1.length];
        while (!maxQueue.isEmpty()) {
            int[] val = maxQueue.poll();
            int i = val[0], maxValue = val[1];

            if (nums1[right] > maxValue) {
                res[i] = nums1[right];
                right--;
            } else {
                res[i] = nums1[left];
                left++;
            }
        }

        return res;
    }
}
