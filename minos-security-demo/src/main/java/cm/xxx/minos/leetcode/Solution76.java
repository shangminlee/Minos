package cm.xxx.minos.leetcode;


import com.alibaba.fastjson.JSON;

/**
 * 739. 每日温度
 * Author: lishangmin
 * Created: 2018-08-23 10:16
 */
public class Solution76 {

    public int[] dailyTemperatures(int[] temperatures) {
        int[] stack = new int[temperatures.length];
        int top = -1;
        int[] result = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (top > -1 && temperatures[i] > temperatures[stack[top]]){
                int index = stack[top--];
                result[index] = i - index;
            }
            stack[++top] = i;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution76 solution = new Solution76();

        int[] data = {73, 74, 75, 75, 69, 72, 76, 73};

        int[] res = solution.dailyTemperatures(data);

        System.out.println(JSON.toJSONString(res));
    }


}
