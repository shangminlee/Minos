package cm.xxx.minos.leetcode;


import com.alibaba.fastjson.JSON;

/**
 * 739. 每日温度
 * Author: lishangmin
 * Created: 2018-08-23 10:16
 */
public class Solution75 {

    public int[] dailyTemperatures(int[] temperatures) {
        int[] result  = new int[temperatures.length];
        for (int i = 0; i < result.length ; i++) {
            int count = 0;
            for (int j = i + 1; j < result.length ; j++) {
                count++;
                if(temperatures[i] < temperatures[j])
                    break;
                if(j == result.length - 1)
                    count = 0;
            }
            result[i] = count;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution75 solution = new Solution75();

        int[] data = {73, 74, 75, 71, 69, 72, 76, 73};

        int[] res = solution.dailyTemperatures(data);

        System.out.println(JSON.toJSONString(res));
    }


}
