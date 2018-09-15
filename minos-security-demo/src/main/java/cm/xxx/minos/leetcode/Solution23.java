package cm.xxx.minos.leetcode;


import cm.xxx.minos.sort.PrintTools;

/**
 * 旋转数组
 * Author: lishangmin
 * Created: 2018-08-23 10:16
 */
public class Solution23 {

    public void rotate(int[] nums, int k) {
        if(nums.length == 0 || k == 0){
            return;
        }
        k = k % nums.length;
        PrintTools.arrayPrint(nums,nums.length - k -1,nums.length - k);
        reverse(nums,0,nums.length - k - 1);
        reverse(nums,nums.length - k,nums.length - 1);
        reverse(nums,0,nums.length-1);
    }
    public void reverse(int[] nums, int start, int end){
        while (start < end){
            nums[start] = nums[start] + nums[end];
            nums[end] = nums[start] - nums[end];
            nums[start++] = nums[start] - nums[end--];
        }
    }

    public static void main(String[] args) {
        Solution23 solution = new Solution23();
        int[] nums = {1,2,3,4,5,6,7};
        solution.rotate(nums,3);
    }

}
