package com.yt.yya.array;

public class N167_TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        int head = 1, tail = numbers.length;

        while (head < tail) {
            int sum = numbers[head - 1] + numbers[tail - 1];
            if (sum == target) {
                return new int[] {head, tail};
            }
            if (sum > target) {
                tail = tail - 1;
            } else {
                head = head + 1;
            }
        }

        return new int[] {-1, -1};
    }
}
