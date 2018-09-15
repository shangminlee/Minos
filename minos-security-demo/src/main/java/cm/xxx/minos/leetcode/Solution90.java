package cm.xxx.minos.leetcode;


/**
 * 33. 搜索旋转排序数组
 * Author: lishangmin
 * Created: 2018-08-23 10:16
 */
public class Solution90 {

    public int search(int[] nums, int target) {
        int left = 0 , right = nums.length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) return mid;
            if(nums[mid] >= nums[left]){
                if(nums[mid] > target && nums[left] <= target){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }else{
                if(nums[mid] < target && nums[right] >= target){
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }

            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution90 solution = new Solution90();
        System.out.println(Integer.MAX_VALUE);
        int[] nums = {3,4,5,6,7,1,2};
        int r = solution.search(nums,4);
        System.out.println(r);
    }

}
