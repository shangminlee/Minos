package cm.xxx.minos.leetcode;


import cm.xxx.minos.sort.PrintTools;

/**
 * Author: lishangmin
 * Created: 2018-08-23 10:16
 */
public class Solution18 {

    public int searchInsert(int[] nums, int target) {
        int low = 0 , high = nums.length;
        while (low < high) {
            int mid = (high + low) / 2;
            PrintTools.arrayPrint(nums,mid,mid);

            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid] < target){
                low = mid + 1;
            }else{
                high = mid;
            }
        }
        return high;
    }

    public static void main(String[] args) {
        Solution18 solution = new Solution18();
        int[] nums = {1,3,5,7,8,9,10,11};
        int m = solution.searchInsert(nums,12);
        System.out.println("m = " + m);
        String value;
    }

}
