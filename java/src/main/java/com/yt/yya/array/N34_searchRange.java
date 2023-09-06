package com.yt.yya.array;

public class N34_searchRange {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[] {-1, -1};
        if (nums == null || nums.length == 0) {
            return result;
        }

        int leftIndex = binarySearch(nums, target, true);
        int rightIndex = binarySearch(nums, target, false);

        if (leftIndex <= rightIndex && rightIndex < nums.length) {
            return new int[] {leftIndex, rightIndex};
        }

        return result;
    }

    private int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0, right = nums.length - 1;
        int ans = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                ans = mid;
                if (lower) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }

        return ans;
    }
}
