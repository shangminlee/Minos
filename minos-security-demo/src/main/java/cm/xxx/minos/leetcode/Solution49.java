package cm.xxx.minos.leetcode;


/**
 * li
 * Author: lishangmin
 * Created: 2018-08-23 10:16
 */
public class Solution49 {

    public int findMaxConsecutiveOnes(int[] nums) {
        int x = 0 , y = 0;
        int count = 0;
        while ( y < nums.length){
            if(nums[y++] != 1){
                count = Math.max(count,y - x - 1);
                x = y;
            }
        }
        return Math.max(count,y - x);
    }

    public static void main(String[] args) {
        Solution49 solution = new Solution49();
        int[] nums = {1,1,1,1,1,0,0,1,1,1,1,1,1};
        System.out.println(solution.findMaxConsecutiveOnes(nums));
    }

}
