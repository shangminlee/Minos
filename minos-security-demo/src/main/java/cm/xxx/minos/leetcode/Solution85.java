package cm.xxx.minos.leetcode;


/**
 * 69. x 的平方根
 * Author: lishangmin
 * Created: 2018-08-23 10:16
 */
public class Solution85 {

    public int mySqrt(int x) {
        if(x == 0) return 0;
        int length = x / 2 + 1;
        int left = 0 , right = length - 1;
        while (left <= right){
            int mid = (left + (right - left) / 2) + 1;
            boolean toRight = false;
            int value = 0;
            if(Integer.MAX_VALUE / mid > mid) {
                value = mid * mid;
                if(value < x) toRight = true;
            }
            if(value == x){
                return mid;
            }else if (toRight){
                left = mid;
            }else{
                right = mid - 2;
            }
        }
        return Math.min(left,right) + 1;
    }


    public static void main(String[] args) {
        Solution85 solution = new Solution85();
        System.out.println(Integer.MAX_VALUE);
        for (int i = 0; i < 100 ; i++) {
            int r = solution.mySqrt(i);
            System.out.println(r);
        }

        int r = solution.mySqrt(4);
        System.out.println(r);

    }

}
