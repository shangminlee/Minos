package cm.xxx.minos.leetcode;


import com.alibaba.fastjson.JSON;

import java.util.HashMap;

/**
 * li
 * Author: lishangmin
 * Created: 2018-08-23 10:16
 */
public class Solution48 {

    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length ; i++) {
            int value = target - numbers[i];
            if(map.containsKey(value)){
                int index1 = map.get(value);
                if(i > index1) return new int[]{index1 + 1,i + 1} ;
            }
            map.put(numbers[i],i);
        }
        return null;
    }

    public static void main(String[] args) {
        Solution48 solution = new Solution48();
        int[] nums = {1,2,3,4,5,6};
        System.out.println(JSON.toJSONString(solution.twoSum(nums,3)));
    }

}
