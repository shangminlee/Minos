package cm.xxx.minos.leetcode;


/**
 * Author: lishangmin
 * Created: 2018-08-23 10:16
 */
public class Solution36 {

    public int dominantIndex(int[] nums) {
        if(nums.length == 1) return 0;
        //找出最大值 索引
        int max = 0;
        for (int i = 0; i < nums.length ; i++) {
            if(nums[i] > nums[max]) max = i;
        }
        //找出第二大值 索引
        int second = max == 0 ? 1 : 0;
        for (int i = 0; i < nums.length ; i++) {
            if(max == i) continue;
            if(nums[i] > nums[second]) second = i;
        }
        return nums[second] * 2 > nums[max] ? -1:max;
    }

    public static void main(String[] args) {
        Solution36 solution = new Solution36();
        int[] nums = {1,2,3,6};
        int s = solution.dominantIndex(nums);
        System.out.println(s);
    }

}
