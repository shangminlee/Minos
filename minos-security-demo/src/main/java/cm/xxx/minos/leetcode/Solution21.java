package cm.xxx.minos.leetcode;


/**
 * Author: lishangmin
 * Created: 2018-08-23 10:16
 */
public class Solution21 {

    public int maxProfit(int[] prices) {
        int balance = 0;
        for (int i = 1; i < prices.length; i++) {
            int buy = prices[i] - prices[i-1];
            if(buy > 0){
                balance = balance + buy;
            }
        }
        return balance;
    }



    public static void main(String[] args) {
        Solution21 solution = new Solution21();
        int[] prices = {2,4,1};
        int balance = solution.maxProfit(prices);
        System.out.println(balance);
    }

}
