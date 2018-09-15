package cm.xxx.minos.leetcode;


/**
 * 69. x 的平方根
 * Author: lishangmin
 * Created: 2018-08-23 10:16
 */
public class Solution87 {

    public int mySqrt(int x) {
        if(x == 0 || x == 1) return x;
        int low = 1 , high = 46340;
        while (low <= high){
            int mid = low + (high - low)/2;
            int square = mid * mid;
            if(square == x){
                return mid;
            }else if(square < x){
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        return Math.min(low,high);
    }


    public static void main(String[] args) {
        Solution87 solution = new Solution87();
        System.out.println(Integer.MAX_VALUE);

        int r = solution.mySqrt(Integer.MAX_VALUE);
        System.out.println(r);

    }

}
