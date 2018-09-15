package cm.xxx.minos.leetcode;


/**
 * 69. x 的平方根
 * Author: lishangmin
 * Created: 2018-08-23 10:16
 */
public class Solution86 {

    public int mySqrt(int x) {
        if(x == 0) return 0;
        long left = 0 , right = x - 1;
        while (left <= right){
            long mid = (left + (right - left) / 2) + 1;
            long value = mid * mid;
            if(value == x){
                return (int) mid;
            }else if (value < x){
                left = mid;
            }else{
                right = mid - 2;
            }
        }
        return (int) (Math.min(left,right) + 1);
    }


    public static void main(String[] args) {
        Solution86 solution = new Solution86();
        System.out.println(Integer.MAX_VALUE);

        int r = solution.mySqrt(Integer.MAX_VALUE);
        System.out.println(r);

    }

}
