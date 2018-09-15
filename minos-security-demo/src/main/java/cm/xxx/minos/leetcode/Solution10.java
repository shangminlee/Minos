package cm.xxx.minos.leetcode;


import java.util.Stack;

/**
 * Description: 滑动窗口 算法
 * Author: lishangmin
 * Created: 2018-08-23 10:16
 */
public class Solution10 {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (Character c: s.toCharArray()) {
            if(c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }else{
                if(stack.empty()) return false;
                Character top = stack.pop();
                if(top == '(' && c != ')'){
                    return false;
                }else
                if(top == '[' && c != ']'){
                    return false;
                }else
                if(top == '{' && c != '}'){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution10 solution = new Solution10();
        System.out.println(solution.isValid("{}())"));
    }

}
