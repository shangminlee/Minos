package cm.xxx.minos.leetcode;

/**
 * Description: 滑动窗口 算法
 * Author: lishangmin
 * Created: 2018-08-23 10:16
 */
public class Solution6 {

    public int reverse(int x) {
        String temp = String.valueOf(x);
        StringBuilder builder = new StringBuilder(0);
        for (int i = temp.length() - 1; i > 0 ; i--) {
            builder.append(temp.charAt(i));
        }
        if(x > 0) builder.append(temp.charAt(0));
        int y = 0;
        try {
            y = Integer.valueOf(builder.toString());
        }catch (NumberFormatException ignored){
        }
        return x < 0 ? ~y + 1 : y;
    }

    public static void main(String[] args) {
        Solution6 solution6 = new Solution6();
        System.out.println(solution6.reverse(901));

        int x = Integer.MAX_VALUE;

        boolean isNegative = x < 0 ? true : false;
        int y = 0;
        int next;
        while (x != 0){
            next = x % 10;
            x = x / 10;
            y = y * 10 + next;
            if (isNegative){
                y = y > 0 ? 0:y;
            }else {
                y = y < 0 ? 0:y;
            }
            System.out.println(y);
        }


    }

}
