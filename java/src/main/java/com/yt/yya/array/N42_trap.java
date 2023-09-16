package com.yt.yya.array;

public class N42_trap {

    public int trap2(int[] height) {
        int n = height.length;
        if (n == 1) {
            return 0;
        }

        int leftMax = 0, rightMax = 0;
        int left = 0, right = n - 1;
        int ans = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            if (height[left] < height[right]) {
                ans += leftMax - height[left];
                left++;
            } else {
                ans += rightMax - height[right];
                right--;
            }
        }

        return ans;
    }


    public int trap(int[] height) {
        int n = height.length;
        if (n == 1) {
            return 0;
        }

        int[] left = new int[height.length];
        int[] right = new int[height.length];

        left[0] = height[0];

        for (int i = 1; i < height.length; i++) {
            left[i] = Math.max(left[i-1], height[i]);
        }

        right[n-1] = height[n-1];
        for (int i = height.length - 2; i >= 0; i--) {
            right[i] = Math.max(right[i+1], height[i]);
        }

        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            ans += Math.min(left[i], right[i]) - height[i];
        }

        return ans;
    }
}
