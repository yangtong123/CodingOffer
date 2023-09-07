package com.yt.yya.array;

public class N528_randomSelectWithWeight {
    class Solution {
        int[] pre;
        int total;

        public Solution(int[] w) {
            pre = new int[w.length];
            pre[0] = w[0];
            for (int i = 1; i < w.length; i++) {
                pre[i] = pre[i-1] + w[i];
            }
            total = pre[w.length - 1];
        }

        public int pickIndex() {
            int pickNum = (int) (Math.random() * total) + 1;
            return binarySearch(pre, pickNum);
        }

        private int binarySearch(int[] pre, int pickNum) {
            int left = 0, right = pre.length - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (pre[mid] > pickNum) {
                    right = mid - 1;
                } else if (pre[mid] < pickNum){
                    left = mid + 1;
                } else {
                    return mid;
                }
            }

            return left;
        }
    }
}
