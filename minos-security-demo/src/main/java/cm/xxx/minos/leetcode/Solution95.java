package cm.xxx.minos.leetcode;


import com.alibaba.fastjson.JSON;

/**
 * 在排序数组中查找元素的第一个和最后一个位置
 * Author: lishangmin
 * Created: 2018-08-23 10:16
 */
public class Solution95 {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findFirst(nums, target);
        result[1] = findLast(nums, target);
        return result;
    }

    public int findFirst(int[] nums, int target){
        int idx = -1;
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int mid = (start + end) / 2;
            if(nums[mid] >= target){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
            if(nums[mid] == target) idx = mid;
        }
        return idx;
    }

    public int findLast(int[] nums, int target){
        int idx = -1;
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int mid = (start + end) / 2;
            if(nums[mid] <= target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
            if(nums[mid] == target) idx = mid;
        }
        return idx;
    }

    public static void main(String[] args) {
        Solution95 solution = new Solution95();
        int[] nums = {1,1,1,1,8,8,8,8};
        int[] r = solution.searchRange(nums,8);
        System.out.println(JSON.toJSONString(r));

    }

}
