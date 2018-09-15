package cm.xxx.minos.leetcode;


import java.util.Map;
import java.util.TreeMap;

/**
 * Description: 滑动窗口 算法
 * Author: lishangmin
 * Created: 2018-08-23 10:16
 */
public class Solution9 {

    private static Map<Character,Integer> ROMA_CHAR_MAP = new TreeMap<>();
    static {
        ROMA_CHAR_MAP.put('I',1);
        ROMA_CHAR_MAP.put('V',5);
        ROMA_CHAR_MAP.put('X',10);
        ROMA_CHAR_MAP.put('L',50);
        ROMA_CHAR_MAP.put('C',100);
        ROMA_CHAR_MAP.put('D',500);
        ROMA_CHAR_MAP.put('M',1000);
    }
    public int romanToInt(String s) {
        int sum = 0;
        for (int i = 0 ; i < s.length() -1; i ++) {
            int n = ROMA_CHAR_MAP.get(s.charAt(i)), m = ROMA_CHAR_MAP.get(s.charAt(i+1));
            sum = n < m ? sum - n + m: sum + n;
        }
        return sum + ROMA_CHAR_MAP.get(s.charAt(s.length()-1));
    }

    public static void main(String[] args) {
        Solution9 solution9 = new Solution9();
        System.out.println(solution9.romanToInt("IIV"));
    }

}
