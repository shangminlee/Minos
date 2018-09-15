package cm.xxx.minos.leetcode;


/**
 * 是否有重复数据
 * Author: lishangmin
 * Created: 2018-08-23 10:16
 */
public class Solution25 {

    public boolean containsDuplicate(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if(nums[i] > nums[j])
                {
                    break;
                }
                else if(nums[i] == nums[j])
                {
                    return true;
                }
            }

        }
        return false;
    }

    public static void main(String[] args) {
        Solution25 solution = new Solution25();
        int[] nums = {7,6,7,4,8,5};
        boolean s = solution.containsDuplicate(nums);
        System.out.println(s);
    }

}
