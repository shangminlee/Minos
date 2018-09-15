package cm.xxx.minos.leetcode;


/**
 * 278. 第一个错误的版本
 * Author: lishangmin
 * Created: 2018-08-23 10:16
 */
public class Solution92 {

    public int firstBadVersion(int n) {
        int left = 1 , right = n;
        while (left < right){
            int mid = left + (right - left) / 2;
            if(isBadVersion(mid)){
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean isBadVersion(int version){
        if(version >= 5) return true;
        return false;
    }

    public static void main(String[] args) {
        Solution92 solution = new Solution92();
        System.out.println(Integer.MAX_VALUE);
        int r = solution.firstBadVersion(9);
        System.out.println(r);
    }

}
