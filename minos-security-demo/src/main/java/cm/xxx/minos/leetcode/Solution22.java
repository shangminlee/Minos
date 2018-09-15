package cm.xxx.minos.leetcode;


/**
 * 旋转数组
 * Author: lishangmin
 * Created: 2018-08-23 10:16
 */
public class Solution22 {

    public void rotate(int[] nums, int k) {
        int n = 0;
        while (n < k){
            int temp = nums[nums.length - 1];
            for (int i = nums.length - 1; i > 0; i--) {
                nums[i] = nums[i-1];
            }
            nums[0] = temp;
            n++;
        }
    }

    public static void main(String[] args) {
        Solution22 solution = new Solution22();
        int[] nums = {1,2,3,4,5,6,7};
        solution.rotate(nums,0);
    }

}
