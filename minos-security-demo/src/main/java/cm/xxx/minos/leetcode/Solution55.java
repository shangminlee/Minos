package cm.xxx.minos.leetcode;


/**
 * 翻转字符串里的单词
 * Author: lishangmin
 * Created: 2018-08-23 10:16
 */
public class Solution55 {

    public String reverseWords(String s) {
        if(s.isEmpty()) return "";
        String[] array = s.split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = array.length - 1; i >= 0 ; i--) {
            if(!array[i].isEmpty()){
                builder.append(array[i]);
                if(i != 0) builder.append(" ");
            }

        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Solution55 solution = new Solution55();
        String s = " the sky is blue ";
        String r = solution.reverseWords(s);
        System.out.println(r.length());
        System.out.println(r);
    }

}
