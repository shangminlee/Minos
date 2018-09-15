package cm.xxx.minos.leetcode;


/**
 * Description: 滑动窗口 算法
 * Author: lishangmin
 * Created: 2018-08-23 10:16
 */
public class Solution8 {

    public boolean isPalindrome(int x) {
        long reverse = 0 , y = x;
        while (y > 0){
            reverse = (reverse + y % 10) * 10;
            y = y / 10;
        }
        reverse = reverse / 10;
        return reverse == x;
    }

    public static void main(String[] args) {
        Solution8 solution7 = new Solution8();
        System.out.println(solution7.isPalindrome(1000000001));
    }

}
