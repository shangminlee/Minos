package cm.xxx.minos.leetcode;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;

/**
 * Description: 两数之和
 * Author: lishangmin
 * Created: 2018-08-22 11:24
 */
public class Solution {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0 ; i < nums.length ; i++){
            int value = target - nums[i];
            if(map.containsKey(value)){
                return new int[]{map.get(value),i};
            }
            map.put(nums[i],i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        Solution solution = new Solution();
        int[] res = solution.twoSum(arr,10);
        System.out.println(JSON.toJSONString(res));
    }
}
