package cm.xxx.minos.leetcode;


/**
 * Author: lishangmin
 * Created: 2018-08-23 10:16
 */
public class Solution43 {

    public String addBinary(String a, String b) {
        int factor = 0;
        int max = Math.max(a.length(),b.length());
        StringBuilder builder = new StringBuilder();
        int x = a.length() - 1, y = b.length() - 1;
        for (int i = 0; i < max; i++) {
            int n = x >= 0? a.charAt(x--) - '0' : 0;
            int m = y >= 0? b.charAt(y--) - '0' : 0;
            int sum = n + m + factor;
            builder.append(sum%2);
            factor = sum / 2;
        }
        if(factor > 0) {
            builder.append(factor);
        }
        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        Solution43 solution = new Solution43();
        solution.addBinary("1110000001","10001");
    }

}
