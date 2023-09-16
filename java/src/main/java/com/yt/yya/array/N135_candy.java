package com.yt.yya.array;

public class N135_candy {

    public int candy(int[] ratings) {
        int[] result = new int[ratings.length];

        for (int i = 0; i < ratings.length; i++) {
            if (i > 0 && ratings[i] > ratings[i-1]) {
                result[i] = result[i-1] + 1;
            } else {
                result[i] = 1;
            }
        }

        int right = 0, sum = 0;
        for (int i = ratings.length - 1; i >= 0; i--) {
            if (i < ratings.length - 1 && ratings[i] > ratings[i+1]) {
                right++;
            } else {
                right = 1;
            }

            sum += Math.max(result[i], right);
        }

        return sum;
    }

    public static void main(String[] args) {
        N135_candy obj = new N135_candy();

        obj.candy(new int[] {1,0,2});
    }
}
