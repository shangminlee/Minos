package cm.xxx.minos.leetcode;


/**
 * Author: lishangmin
 * Created: 2018-08-23 10:16
 */
public class Solution14 {

    public int removeDuplicates(int[] nums) {
        int i = 0 ;
        int n = 0 ;
        while (i < nums.length -1){
            if(nums[i++] == nums[i]){
                continue;
            }
            nums[n++] = nums[i];
        }
        return ++n;
    }


    public static void main(String[] args) {
        Solution14 solution = new Solution14();
        int[] nums = {1,1,3,3};
        int sum = solution.removeDuplicates(nums);
        System.out.println(sum);
    }

}
