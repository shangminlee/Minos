package cm.xxx.minos.leetcode;


/**
 * li
 * Author: lishangmin
 * Created: 2018-08-23 10:16
 */
public class Solution52 {

    public int minSubArrayLen(int s, int[] nums) {
        int x = 0 , y = 0;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        while (y < nums.length){
            sum += nums[y];
            while (sum >= s){
                min = Math.min(y - x + 1,min);
                sum -= nums[x++];
            }
            y++;
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public static void main(String[] args) {
        Solution52 solution = new Solution52();
        int s = 11;
//        int[] nums = {2,3,1,2,4,3};
        int[] nums = {1,2,3,4,5};
        System.out.println(solution.minSubArrayLen(s,nums));
    }

}
