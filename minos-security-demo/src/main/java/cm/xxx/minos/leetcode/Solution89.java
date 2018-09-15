package cm.xxx.minos.leetcode;


/**
 * 33. 搜索旋转排序数组
 * Author: lishangmin
 * Created: 2018-08-23 10:16
 */
public class Solution89 {

    public int search(int[] nums, int target) {
        //找到偏移量
        int k = 0;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] < nums[i - 1]){
                k = i;
                break;
            }
        }
        int left = 0 , right = nums.length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            int shift = (mid + k) % nums.length;
            if(nums[shift] == target) return shift;
            else if (nums[shift] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution89 solution = new Solution89();
        System.out.println(Integer.MAX_VALUE);
        int[] nums = {3,4,5,6,7,1,2};
        int r = solution.search(nums,6);
        System.out.println(r);
    }

}
