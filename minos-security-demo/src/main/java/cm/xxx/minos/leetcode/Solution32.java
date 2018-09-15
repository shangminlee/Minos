package cm.xxx.minos.leetcode;


/**
 * Author: lishangmin
 * Created: 2018-08-23 10:16
 */
public class Solution32 {

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1 ; i >= 0 ; i--){
            if(digits[i] == 9){
                digits[i] = 0;
            }else{
                digits[i] += 1;
                return digits;
            }
        }
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }

    public static void main(String[] args) {
        Solution32 solution = new Solution32();
        int[] nums = {1,9,9};
        int[] s = solution.plusOne(nums);
        for (int a : s) {
            System.out.println(a);
        }
    }

}
