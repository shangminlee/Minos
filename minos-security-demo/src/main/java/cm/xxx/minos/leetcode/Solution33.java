package cm.xxx.minos.leetcode;


/**
 * Author: lishangmin
 * Created: 2018-08-23 10:16
 */
public class Solution33 {

    public void moveZeroes(int[] nums) {
        int n = 0,m = 0;
        while (n < nums.length){
            if(nums[n] != 0) {
                nums[m] = nums[n];
                nums[n] = n != m++ ? 0:nums[n];
            }
            n++;
        }
    }

    public static void main(String[] args) {
        Solution33 solution = new Solution33();
        int[] nums = {1,0,2,0,3};
        solution.moveZeroes(nums);
        for (int a :
                nums) {
            System.out.println(a);
        }
    }

}
