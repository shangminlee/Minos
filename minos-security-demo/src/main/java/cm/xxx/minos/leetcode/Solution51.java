package cm.xxx.minos.leetcode;


import cm.xxx.minos.sort.PrintTools;

/**
 * li
 * Author: lishangmin
 * Created: 2018-08-23 10:16
 */
public class Solution51 {

    public int minSubArrayLen(int s, int[] nums) {
        int x = 0 , y = 0;
        int min = 0,count = 0;
        int sum = 0;

        while (y < nums.length) {
            x = y;
            while (x < nums.length) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                PrintTools.arrayPrint(nums, y, x);
                sum += nums[x];
                count++;
                System.out.println("##count : " + count + " min : " + min + " sum : " + sum + " s : " + s);
                if (sum >= s) {
                    if (count == 1) return count;
                    min = min == 0 ? count : Math.min(count, min);
                    sum = 0;
                    count = 0;
                } else {
                    x++;
                }
                System.out.println("@@count : " + count + " min : " + min + " sum : " + sum + " s : " + s);
                System.out.println();
            }
            if(min == 2) return min;
            y++;
            sum = 0;
            count = 0;
        }
        return min;
    }

    public static void main(String[] args) {
        Solution51 solution = new Solution51();
        int s = 11;
//        int[] nums = {2,3,1,2,4,3};
        int[] nums = {1,2,3,4,5};
        System.out.println(solution.minSubArrayLen(s,nums));
    }

}
