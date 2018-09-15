package cm.xxx.minos.leetcode;


import java.util.Arrays;

/**
 * Author: lishangmin
 * Created: 2018-08-23 10:16
 */
public class Solution45 {

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int x = 0 , y = 1;
        int sum = 0;
        while (y < nums.length){
            sum += nums[x] > nums[y]?nums[y]:nums[x];
            x+=2;
            y+=2;
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution45 solution = new Solution45();
        int[] nums = {1,4,3,2,5,6};
        System.out.println(solution.arrayPairSum(nums));
    }

}
