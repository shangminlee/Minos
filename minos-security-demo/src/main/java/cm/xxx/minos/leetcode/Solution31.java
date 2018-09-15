package cm.xxx.minos.leetcode;


/**
 * Author: lishangmin
 * Created: 2018-08-23 10:16
 */
public class Solution31 {

    public int[] plusOne(int[] digits) {
        int factor = 1;
        for (int i = digits.length - 1 ; i >= 0 && factor > 0 ; i--){
            int m = digits[i] + factor;
            digits[i] = m % 10;
            factor = m / 10;
        }
        if (factor == 0){
            return digits;
        }
        int[] result = new int[digits.length + 1];
        result[0] = factor;
        return result;
    }

    public static void main(String[] args) {
        Solution31 solution = new Solution31();
        int[] nums = {9,9,9};
        int[] s = solution.plusOne(nums);
        for (int a : s) {
            System.out.println(a);
        }
    }

}
