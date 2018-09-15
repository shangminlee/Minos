package cm.xxx.minos.leetcode;


/**
 * 150. 逆波兰表达式求值
 * Author: lishangmin
 * Created: 2018-08-23 10:16
 */
public class Solution79 {

    public int evalRPN(String[] tokens) {
        if(tokens.length == 0) return 0;
        int[] stack = new int[tokens.length];
        int top = -1;
        for (String token : tokens) {
            if("+".equals(token)){
                int a = stack[top--];
                int b = stack[top--] + a;
                stack[++top] = b;
                continue;
            }
            if("-".equals(token)){
                int a = stack[top--];
                int b = stack[top--] - a;
                stack[++top] = b;
                continue;
            }
            if("*".equals(token)){
                int a = stack[top--];
                int b = stack[top--] * a;
                stack[++top] = b;
                continue;
            }
            if("/".equals(token)){
                int a = stack[top--];
                int b = stack[top--] / a;
                stack[++top] = b;
                continue;
            }
            stack[++top] = Integer.valueOf(token);

        }
        return stack[top];
    }

    public static void main(String[] args) {
        Solution79 solution = new Solution79();
        String[] req = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        solution.evalRPN(req);
    }


}
