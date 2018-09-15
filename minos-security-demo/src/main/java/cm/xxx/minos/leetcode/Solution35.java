package cm.xxx.minos.leetcode;


/**
 * Author: lishangmin
 * Created: 2018-08-23 10:16
 */
public class Solution35 {

    public int pivotIndex(int[] nums) {
        if(nums.length == 1)return 0;
        int left = 0;
        int right = this.add(nums);
        for (int i = 0; i < nums.length ; i++) {
            left = i > 0 ? left + nums[i-1] : left;
            right = right - nums[i];
            if(left == right) return i;
        }
        return -1;
    }

    public int add(int[] nums){
        int sum = 0;
        for (int i = 0; i < nums.length ; i++) {
            sum += nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution35 solution = new Solution35();
        int[] nums = {1,7,3,6,5,6};
        int i = solution.pivotIndex(nums);
        System.out.println(i);
    }

}
