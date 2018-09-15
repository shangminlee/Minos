package cm.xxx.minos.leetcode;


/**
 * 153. 寻找旋转排序数组中的最小值
 * Author: lishangmin
 * Created: 2018-08-23 10:16
 */
public class Solution93 {
    public int findMin(int[] nums) {
        int left = 0 , right = nums.length - 1;
        while (left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] < nums[right]){
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        return nums[right];
    }

    public static void main(String[] args) {
        Solution93 solution = new Solution93();
        int[] nums = {10,11,12,13,14,15,16,8,9};
        System.out.println(solution.findMin(nums));
    }

}
