package cm.xxx.minos.leetcode;


/**
 * 反转字符串中的单词 III
 * Author: lishangmin
 * Created: 2018-08-23 10:16
 */
public class Solution56 {

    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int x = 0 , y = 0 ;
        while (y < chars.length) {
            if(chars[y] == ' '){
                if(x != y) {
                    this.reverse(chars, x, y - 1);
                }
                x = ++y;
            }else if( x != y && y == chars.length - 1){
                this.reverse(chars, x, y);
                y++;
            }else{
                y++;
            }
        }
        return new String(chars);
    }

    public void reverse(char[] chars , int start , int end){
        while (start < end){
            char temp = chars[start];
            chars[start++] = chars[end];
            chars[end--] = temp;
        }
    }

    public static void main(String[] args) {
        Solution56 solution = new Solution56();
        String s = "Let's take LeetCode contest";
        String r = solution.reverseWords(s);
        System.out.println(r.length());
        System.out.println(r);
    }

}
