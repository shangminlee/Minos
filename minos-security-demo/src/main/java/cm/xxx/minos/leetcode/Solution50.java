package cm.xxx.minos.leetcode;


/**
 * li
 * Author: lishangmin
 * Created: 2018-08-23 10:16
 */
public class Solution50 {

    public int findMaxConsecutiveOnes(int[] nums) {
        int x = 0;
        int count = 0, max = 0;
        while ( x < nums.length){
            if(nums[x++] == 1){
                count++;
            }else {
                max = Math.max(max,count);
                count = 0;
            }
        }
        return Math.max(max,count);
    }

    public static void main(String[] args) {
        Solution50 solution = new Solution50();
        int[] nums = {1,1,1,1,1,0};
        System.out.println(solution.findMaxConsecutiveOnes(nums));
    }

}
