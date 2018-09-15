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
public class Solution80 {

    public String decodeString(String s) {
        String[] stack = new String[s.length()];
        int top = -1;
        for (int i = 0; i < s.length() ; i++) {
            if(']' == s.charAt(i)){
                //统计字符串
                StringBuilder value = new StringBuilder();
                while ('[' != stack[top].charAt(0)){
                    value.insert(0,String.valueOf(stack[top--]));
                }
                //统计数字
                --top;
                StringBuilder digit = new StringBuilder();
                digit.append(stack[top--]);
                while (top > -1 && Character.isDigit(stack[top].charAt(0))){
                    digit.insert(0,String.valueOf(stack[top--]));
                }
                //计算字符串
                int count = Integer.valueOf(digit.toString());
                String temp = value.toString();
                for (int j = 0; j < count - 1 ; j++) {
                    value.append(temp);
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
        Solution80 solution = new Solution80();
        String s = "3[a3[gk]]";
//        String s = "10[ab]";
        String a = solution.decodeString(s);
        System.out.println(a);
    }


}
