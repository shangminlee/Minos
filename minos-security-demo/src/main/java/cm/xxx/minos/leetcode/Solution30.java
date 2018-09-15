package cm.xxx.minos.leetcode;


/**
 * Author: lishangmin
 * Created: 2018-08-23 10:16
 */
public class Solution30 {

    public int[] plusOne(int[] digits) {
        int len = digits.length;
        for (int i = len - 1; i > -1; i--) {
            if (digits[i] == 9 ) {
                digits[i] = 0;
            } else {
                digits[i] += 1;
                return digits;
            }
        }
        int[] newArray = new int[len + 1];
        newArray[0] = 1;
        return newArray;
    }

    public static void main(String[] args) {
        Solution30 solution = new Solution30();
        int[] nums = {9,9,9};
        int[] s = solution.plusOne(nums);
        for (int a : s) {
            System.out.println(a);
        }
    }

}
