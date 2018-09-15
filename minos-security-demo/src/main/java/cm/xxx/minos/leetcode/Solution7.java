package cm.xxx.minos.leetcode;


import java.util.Stack;

/**
 * Description: 滑动窗口 算法
 * Author: lishangmin
 * Created: 2018-08-23 10:16
 */
public class Solution7 {

    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        if(x < 10) return true;
        String y = String.valueOf(x);
        int mid = y.length() / 2;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < y.length() && y.length() > 1; i++) {
            if(i < y.length() / 2) {
                stack.push(y.charAt(i));
            }else {
                if(y.length()%2 >0 && i == mid) continue;
                if(y.charAt(i) != stack.pop()){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution7 solution7 = new Solution7();
        System.out.println(solution7.isPalindrome(1));
    }

}
