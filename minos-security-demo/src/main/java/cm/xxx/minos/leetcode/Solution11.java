package cm.xxx.minos.leetcode;


import java.util.Stack;

/**
 * Description: 滑动窗口 算法
 * Author: lishangmin
 * Created: 2018-08-23 10:16
 */
public class Solution11 {

    public String longestCommonPrefix(String[] strs) {
        Stack<Character> stack = new Stack<>();
        StringBuilder stringBuilder = new StringBuilder("");
        int length = strs.length > 0 ? strs[0].length() : 0;
        for (int i = 0 ; i < length ; i++){
            stack.push(strs[0].charAt(i));
            for(int j = 1 ; j < strs.length ; j++){
                String str = strs[j];
                if(i == str.length() || stack.peek() != str.charAt(i)){
                    stack.pop();
                    i = length;
                    break;
                }
            }
            if(!stack.empty()) {
                stringBuilder.append(stack.pop());
            }
        }
        return stringBuilder.toString();
    }


    public static void main(String[] args) {
        Solution11 solution = new Solution11();
        String[] strs = {"aa","ab","abc"};
        System.out.println(solution.longestCommonPrefix(strs));
    }

}
