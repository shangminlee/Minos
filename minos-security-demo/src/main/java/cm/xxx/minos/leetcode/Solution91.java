package cm.xxx.minos.leetcode;


/**
 * 278. 第一个错误的版本
 * Author: lishangmin
 * Created: 2018-08-23 10:16
 */
public class Solution91 {

    public int firstBadVersion(int n) {
        int left = 0 , right = n;
        while (left <= right){
            int mid = left + (right - left) / 2;
            boolean x = isBadVersion(mid);
            boolean y = isBadVersion(mid - 1);
            if(x && !y) {
                return mid;
            }
            if(x){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return -1;
    }

    private boolean isBadVersion(int version){
        if(version >= 5) return true;
        return false;
    }

    public static void main(String[] args) {
        Solution91 solution = new Solution91();
        System.out.println(Integer.MAX_VALUE);
        int r = solution.firstBadVersion(3);
        System.out.println(r);
    }

}
