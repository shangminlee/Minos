package cm.xxx.minos.leetcode;


import com.alibaba.fastjson.JSON;

/**
 * li
 * Author: lishangmin
 * Created: 2018-08-23 10:16
 */
public class Solution47 {

    public int[] twoSum(int[] numbers, int target) {
        int x = 0 , y = numbers.length - 1;
        while (x < y){
            if(target > numbers[x] + numbers[y]){
                x++;
            }else if (target < numbers[x] + numbers[y]){
                y--;
            }else {
                return new int[]{x+1,y+1};
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Solution47 solution = new Solution47();
        int[] nums = {1,2,3,4,5,6};
        System.out.println(JSON.toJSONString(solution.twoSum(nums,0)));
    }

}
