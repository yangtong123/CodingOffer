package com.yt.yya.array;

import java.util.ArrayList;
import java.util.List;

public class N54_spiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        List<Integer> result = new ArrayList<>(cols * rows);

        int left = 0, top = 0, right = cols - 1, bottom = rows - 1;

        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }

            for (int i = top + 1; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }

            if (left < right && top < bottom) {
                for (int i = right - 1; i >= left + 1; i--) {
                    result.add(matrix[bottom][i]);
                }

                for (int i = bottom; i >= top + 1; i--) {
                    result.add(matrix[i][left]);
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
