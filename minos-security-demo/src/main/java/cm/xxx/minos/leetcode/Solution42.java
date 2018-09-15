package cm.xxx.minos.leetcode;


import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 杨辉三角
 * Author: lishangmin
 * Created: 2018-08-23 10:16
 */
public class Solution42 {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if(numRows == 0) return result;
        result.add(Collections.singletonList(1));
        for (int i = 1; i < numRows ; i++) {
            List<Integer> child = new ArrayList<>();
            child.add(1);
            List<Integer> parent = result.get(i - 1);
            for (int j = 1; j < i ; j++) {
                child.add(parent.get(j-1) + parent.get(j));
            }
            child.add(1);
            result.add(child);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution42 solution = new Solution42();

        System.out.println(JSON.toJSONString(solution.generate(0)));
        System.out.println(JSON.toJSONString(solution.generate(1)));
        System.out.println(JSON.toJSONString(solution.generate(2)));
        System.out.println(JSON.toJSONString(solution.generate(3)));
        System.out.println(JSON.toJSONString(solution.generate(4)));
        System.out.println(JSON.toJSONString(solution.generate(5)));
        System.out.println(JSON.toJSONString(solution.generate(6)));
        System.out.println(JSON.toJSONString(solution.generate(7)));
        System.out.println(JSON.toJSONString(solution.generate(8)));
        System.out.println(JSON.toJSONString(solution.generate(9)));
        System.out.println(JSON.toJSONString(solution.generate(10)));
        System.out.println(JSON.toJSONString(solution.generate(11)));
    }

}
