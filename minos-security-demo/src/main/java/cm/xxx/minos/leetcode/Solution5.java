package cm.xxx.minos.leetcode;

import java.util.HashSet;

/**
 * Description:
 * Author: lishangmin
 * Created: 2018-08-23 10:16
 */
public class Solution5 {

    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 1){
            return s.length();
        }
        int length = 0;
        HashSet<Character> set = new HashSet<>();
        int halfLength = s.length() / 2;
        for (int i = 0 ; i < s.length() ; i++){
            if(i >= halfLength && length > halfLength ){
                break;
            }
            for (int n = i; n < s.length(); n++) {
                if(!set.contains(s.charAt(n))){
                    set.add(s.charAt(n));
                }else {
                    int size = set.size();
                    length = size > length? size:length;
                    set.clear();
                    break;
                }
            }
        }
        return length;
    }

    public static void main(String[] args) {
        Solution5 solution5 = new Solution5();
        int length = solution5.lengthOfLongestSubstring("aabbcc");
        System.out.println("length : " + length);
    }
}
