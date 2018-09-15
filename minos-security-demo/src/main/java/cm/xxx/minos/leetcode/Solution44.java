package cm.xxx.minos.leetcode;


/**
 * Author: lishangmin
 * Created: 2018-08-23 10:16
 */
public class Solution44 {

    public String reverseString(String s) {
        if(s == null || s.isEmpty()) return "";
        int x = 0 , y = s.length() - 1;
        char[] chars = s.toCharArray();
        while (x < y){
            char temp = chars[x];
            chars[x++] = chars[y];
            chars[y--] = temp;
        }
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        Solution44 solution = new Solution44();
        System.out.println(solution.reverseString("abc lalal ,a "));
    }

}
