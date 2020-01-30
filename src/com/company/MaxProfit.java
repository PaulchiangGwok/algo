package com.company;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 */
public class MaxProfit {
    public static void main(String[] args) {
        int[] input = {7,1,5,3,6,4};
        System.out.println(maxProfit(input));
    }


    public static int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        //int[] profit = new int[prices.length];
        int maxProfit = 0;
        for(int i = 0 ;i < prices.length;i++){
            int handle = prices[i];
            if(handle < min){
                min = handle;
            } else {
                maxProfit = Integer.max(maxProfit,handle - min);
            }
        }
        return maxProfit;
    }
}
