package cm.xxx.minos.leetcode;


import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角 II
 * Author: lishangmin
 * Created: 2018-08-23 10:16
 */
public class Solution53 {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        long next = 1;
        for (int i = 0; i <= rowIndex ; i++) {
            result.add((int) next);
            next = next * (rowIndex - i) / (i + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution53 solution = new Solution53();
        int s = 3;
        System.out.println(JSON.toJSONString(solution.getRow(s)));
    }

}
