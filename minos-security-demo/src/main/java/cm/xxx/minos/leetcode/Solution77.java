package cm.xxx.minos.leetcode;


import java.util.Stack;

/**
 * 150. 逆波兰表达式求值
 * Author: lishangmin
 * Created: 2018-08-23 10:16
 */
public class Solution77 {

    private enum Calculate{
        ADD {
            @Override
            public int cal(int x, int y) {
                return y + x;
            }
        },
        SUB{
            @Override
            public int cal(int x, int y) {
                return y - x;
            }
        },
        DIV {
            @Override
            public int cal(int x, int y) {
                return y / x;
            }
        },
        MUL {
            @Override
            public int cal(int x, int y) {
                return y * x;
            }
        };
        public abstract int cal(int x, int y);
    }

    public int evalRPN(String[] tokens) {
        if(tokens.length == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if ("+".equals(token)) {
                stack.push(Calculate.ADD.cal(stack.pop(), stack.pop()));
            } else if ("-".equals(token)) {
                stack.push(Calculate.SUB.cal(stack.pop(), stack.pop()));
            } else if ("*".equals(token)) {
                stack.push(Calculate.MUL.cal(stack.pop(), stack.pop()));
            } else if ("/".equals(token)) {
                stack.push(Calculate.DIV.cal(stack.pop(), stack.pop()));
            } else {
                stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        Solution77 solution = new Solution77();

    }


}
