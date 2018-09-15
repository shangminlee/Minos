package cm.xxx.minos.leetcode;


/**
 * 394. 字符串解码
 * 测试用例：
 * "3[a]2[bc]"
 * "3[a2[c]]"
 * "2[abc]3[cd]ef"
 * "2[abc]3[cd]ef4[f]3[a3[gk]]"
 * "100[leetcode]"
 * "3[a]2[b4[F]c]"
 * "3[a3[gk]]"
 * Author: lishangmin
 * Created: 2018-08-23 10:16
 */
public class Solution81 {

    public String decodeString(String s) {
        String[] stack = new String[s.length()];
        int top = -1;
        for (int i = 0; i < s.length() ; i++) {
            if(']' == s.charAt(i)){
                //统计字符串
                String[] temp = new String[s.length()];
                int tail = -1;
                while ('[' != stack[top].charAt(0)){
                    temp[++tail] = stack[top--];
                }
                //统计数字
                --top;
                int count = stack[top--].charAt(0) - '0', factor = 10;
                while (top > -1 && Character.isDigit(stack[top].charAt(0))){
                    count = factor * (stack[top--].charAt(0) - '0') + count;
                    factor = factor * 10;
                }
                //计算字符串
                StringBuilder value = new StringBuilder();
                for (int j = count * (tail + 1) - 1; j >= 0  ; j--) {
                    value.append(temp[j % (tail + 1)]);
                }
                stack[++top] = value.toString();
            }else{
                stack[++top] = String.valueOf(s.charAt(i));
            }
        }
        StringBuilder result = new StringBuilder();
        int index = 0;
        while (index <= top){
            result.append(stack[index++]);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Solution81 solution = new Solution81();
//        String s = "101[a3[gk]]";
        String s = "3[ab]";
        String a = solution.decodeString(s);
        System.out.println(a);
    }


}
