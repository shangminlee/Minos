package cm.xxx.minos.leetcode;


/**
 * 是否有重复数据
 * Author: lishangmin
 * Created: 2018-08-23 10:16
 */
public class Solution26 {

    public int singleNumber(int[] nums) {
        for (int i = 0 ; i < nums.length; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if(nums[i] == nums[j]) count++;
                if(count > 1)break;
            }
            if(count == 1) return nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution26 solution = new Solution26();
        int[] nums = {2,4,2,3,2,3};
        int s = solution.singleNumber(nums);
        System.out.println(s);
    }

}
