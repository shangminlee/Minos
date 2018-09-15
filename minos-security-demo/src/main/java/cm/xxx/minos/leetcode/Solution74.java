package cm.xxx.minos.leetcode;


/**
 * 458. 可怜的小猪
 * Author: lishangmin
 * Created: 2018-08-23 10:16
 */
public class Solution74 {

    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int timesToTest = minutesToTest / minutesToDie;
        int count = 0;
        while (buckets > 0){
            buckets = buckets / timesToTest;
            count++;
        }
        return count;
    }


}
