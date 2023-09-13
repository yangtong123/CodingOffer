package com.yt.yya.array;

public class N121_maxProfit {
    public int maxProfit(int[] prices) {
        int minValue = Integer.MAX_VALUE;
        int result = 0;

        for (int price : prices) {
            if (price < minValue) {
                minValue = price;
            } else if (price - minValue > result) {
                result = Math.max(result, price - minValue);
            }
        }

        return result;
    }
}
