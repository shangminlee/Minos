package cm.xxx.minos.leetcode;


import java.util.Stack;

/**
 * 150. 逆波兰表达式求值
 * Author: lishangmin
 * Created: 2018-08-23 10:16
 */
public class Solution78 {


    public int evalRPN(String[] tokens) {
        if(tokens.length == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if("+-*/".contains(token)){
                int a = stack.pop();
                int b = stack.pop();
                switch (token){
                    case "+" : b += a;break;
                    case "-" : b -= a;break;
                    case "*" : b *= a;break;
                    case "/" : b /= a;break;
                }
                stack.push(b);
            }else{
                stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        Solution78 solution = new Solution78();
        String[] req = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        solution.evalRPN(req);
    }


}
