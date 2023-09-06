package com.yt.yya.array;

public class N410_splitArray {
    public int splitArray(int[] nums, int k) {
        int left = 0, right = 0;
        for (int i = 0; i < nums.length; i++) {
            right += nums[i];
            if (left < nums[i]) {
                left = nums[i];
            }
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (f(nums, mid) <= k) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public int f(int[] nums, int x) {
        int remain = x;
        int cnt = 1;

        for (int num : nums) {
            if (remain >= num) {
                remain -= num;
            } else {
                cnt++;
                remain = x - num;
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        int[] input = {5,1,3,5,10,7,4,9,2,8};
        N410_splitArray obj = new N410_splitArray();
        obj.splitArray(input, 1);
    }
}
