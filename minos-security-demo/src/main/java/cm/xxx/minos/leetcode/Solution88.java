package cm.xxx.minos.leetcode;


/**
 * 374. 猜数字大小
 * Author: lishangmin
 * Created: 2018-08-23 10:16
 */
public class Solution88 {

    public int guessNumber(int x) {
        int low = 0 , high = x;
        while (low <= high){
            int mid = low + (high - low)/2;
            int val = guess(mid) ;
            if(val == 0){
                return mid;
            }else if(val == 1){
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        return Math.min(low,high);
    }

    private int guess(int n){
        return -1;
    }


    public static void main(String[] args) {
        Solution88 solution = new Solution88();
        System.out.println(Integer.MAX_VALUE);


    }

}
