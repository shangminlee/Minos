package cm.xxx.minos.leetcode;


/**
 * 162. 寻找峰值
 * Author: lishangmin
 * Created: 2018-08-23 10:16
 */
public class Solution94 {
    public int findPeakElement(int[] nums) {
        int left = 0 , right = nums.length - 1;
        while (left <= right){
            if(left == right) return left;
            int mid = left + (right - left) / 2;
            if(nums[mid] < nums[mid + 1]){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        Solution94 solution = new Solution94();
        int[] nums = {1,2,3,4,2,1};
        System.out.println(solution.findPeakElement(nums));
    }

}
