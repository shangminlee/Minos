package cm.xxx.minos.leetcode;


/**
 * Author: lishangmin
 * Created: 2018-08-23 10:16
 */
public class Solution19 {

    public int strStr(String haystack, String needle) {
        if(needle.isEmpty()) return -1;
        char[] source = haystack.toCharArray(), target = needle.toCharArray();
        for (int i = 0; i < source.length - target.length + 1 ; i++) {
            if(source[i] == target[0]){
                int m = i + 1 , n = 1;
                while (n < target.length){
                    if(source[m] != target[n]) break;
                    n++;
                    m++;
                }
                if(n == target.length) return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution19 solution = new Solution19();
        String value = "noddlo";
        String factor = "lo";
        int r = solution.strStr(value,factor);
        System.out.println(r);
    }

}
