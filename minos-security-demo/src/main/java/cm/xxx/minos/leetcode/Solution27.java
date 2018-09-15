package cm.xxx.minos.leetcode;


import java.util.Arrays;

/**
 * 是否有重复数据
 * Author: lishangmin
 * Created: 2018-08-23 10:16
 */
public class Solution27 {

    public int singleNumber(int[] nums) {
        if(nums.length == 1) return nums[0];
        Arrays.sort(nums);
        if(nums[0] != nums[1]) return nums[0];
        if(nums[nums.length-1] != nums[nums.length -2]) return nums[nums.length-1];
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] != nums[i-1] && nums[i] != nums[i+1])
                return nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution27 solution = new Solution27();
        int[] nums = {1,2,4,2,3,2,3,4,5};
        int s = solution.singleNumber(nums);
        System.out.println(s);
    }

}
