package com.ds.algo.facebook.leetcode;

public class BuySellStock {

    public static void main(String[] args) {
        int[] prices  = {7,1,5,3,6,4};
        int profit = BuySellStock.maxProfit(prices);
        System.out.println("profit = " + profit);

    }
    public static int maxProfit(int[] prices){
        if(prices == null || prices.length == 0)
            return 0;
        int min = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if(prices[i] > min){
                int profit = prices[i] - min;
                maxProfit = Math.max(maxProfit, profit);
            } else {
                min = prices[i];
            }
        }
        return maxProfit;
    }
}
