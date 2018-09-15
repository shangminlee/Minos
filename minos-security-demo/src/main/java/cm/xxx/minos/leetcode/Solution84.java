package cm.xxx.minos.leetcode;


/**
 * 704. 二分查找
 * Author: lishangmin
 * Created: 2018-08-23 10:16
 */
public class Solution84 {

    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0)
            return -1;
        int left = 0 , right = nums.length - 1;
        while (left <= right){
            int mid = left + (right - left)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        Solution84 solution = new Solution84();
        int[] matrix = {1,2,3,4,5,6,7,8};
        int r = solution.search(matrix,5);
        System.out.println(r);
    }

}
