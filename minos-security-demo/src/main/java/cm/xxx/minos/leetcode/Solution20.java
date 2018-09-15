package cm.xxx.minos.leetcode;


/**
 * Author: lishangmin
 * Created: 2018-08-23 10:16
 */
public class Solution20 {

    public int maxProfit(int[] prices) {
        int buy = 0;
        int balance = 0;
        for (int i = 1; i < prices.length; i++) {
            if(buy == 0){
                buy = prices[i];
            }else if(buy > 0 && this.isMax(prices,i)){
                balance = balance + (prices[i] - buy);
                break;
            }
        }
        return balance;
    }

    public boolean isMin(int[] prices,int index){
        for (int i = index + 1; i < prices.length ; i++) {
            int n = prices[index];
            if(prices[i] < n){
                return false;
            }
        }
        return true;
    }

    public boolean isMax(int[] prices,int index){
        for (int i = index + 1; i < prices.length ; i++) {
            int n = prices[index];
            if(prices[i] > n){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution20 solution = new Solution20();
        int[] prices = {2,4,1};
        int balance = solution.maxProfit(prices);
        System.out.println(balance);
    }

}
