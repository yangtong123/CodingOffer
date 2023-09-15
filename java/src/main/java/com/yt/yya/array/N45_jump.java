package com.yt.yya.array;

public class N45_jump {

    public int jump(int[] nums) {
        int end = 0, step = 0;
        int maxPosition = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length - 1; i++) {
            maxPosition = Math.max(maxPosition, nums[i] + i);

            if (i == end) {
                end = maxPosition;
                step++;
            }
        }

        return step;
    }
}
