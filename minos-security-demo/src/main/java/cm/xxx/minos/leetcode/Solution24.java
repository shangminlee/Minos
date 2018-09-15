package cm.xxx.minos.leetcode;


import java.util.HashSet;

/**
 * 是否有重复数据
 * Author: lishangmin
 * Created: 2018-08-23 10:16
 */
public class Solution24 {

    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if(set.contains(num)){
                return true;
            }
            set.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        Solution24 solution = new Solution24();

    }

}
