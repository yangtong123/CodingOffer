package com.yt.yya.array;

public class N122_maxProfit {

    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];

        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
        }

        return dp[prices.length - 1][0];
    }

    public int maxProfit2(int[] prices) {
        int dp0 = 0, dp1 = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            dp0 = Math.max(dp0, dp1 + prices[i]);
            dp1 = Math.max(dp1, dp0 - prices[i]);
        }

        return dp0;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        N122_maxProfit obj = new N122_maxProfit();
        int maxProfit = obj.maxProfit(prices);

        System.out.println(maxProfit);
    }
}
