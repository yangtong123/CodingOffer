package com.yt.yya.array;

public class N59_generateMatrix {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];

        int left = 0, top = 0, right = n - 1, bottom = n - 1;
        int i = 1;
        while (left <= right && top <= bottom) {
            for (int col = left; col <= right; col++) {
                result[top][col] = i++;
            }

            for (int row = top+1; row <= bottom; row++) {
                result[row][right] = i++;
            }

            if (left < right && top < bottom) {
                for (int col = right - 1; col >= left + 1; col--) {
                    result[bottom][col] = i++;
                }

                for (int row = bottom; row >= top+1; row--) {
                    result[row][left] = i++;
                }
            }

            left++;
            right--;
            top++;
            bottom--;
        }

        return result;
    }
}
