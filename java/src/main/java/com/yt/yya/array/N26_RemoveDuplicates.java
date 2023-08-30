package com.yt.yya.array;

public class N26_RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        int slow = 1, fast = 1;
        while (fast < n) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow] = nums[fast];
                slow++;
            }

            fast++;
        }

        return slow;
    }
}
