package cm.xxx.minos.leetcode;


import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 杨辉三角 II
 * Author: lishangmin
 * Created: 2018-08-23 10:16
 */
public class Solution54 {

    public List<Integer> getRow(int rowIndex) {
        rowIndex++;
        List<Integer> previous,result = Collections.singletonList(1);
        for (int i = 1; i < rowIndex; i++) {
            previous = result;
            result = new ArrayList<>();
            result.add(1);
            for (int j = 1; j < i ; j++) {
                result.add(previous.get(j) + previous.get(j-1));
            }
            result.add(1);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution54 solution = new Solution54();
        int s = 3;
        System.out.println(JSON.toJSONString(solution.getRow(0)));
    }

}
