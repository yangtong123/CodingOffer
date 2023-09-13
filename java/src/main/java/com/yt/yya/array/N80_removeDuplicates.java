package com.yt.yya.array;

public class N80_removeDuplicates {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1 || nums.length == 2) {
            return nums.length;
        }

        int slow = 2, fast = 2;
        while (fast < nums.length) {
            if (nums[fast] != nums[slow - 2]) {
                nums[slow] = nums[fast];
                slow ++;
            }

            fast++;
        }

        return slow;
    }
}
