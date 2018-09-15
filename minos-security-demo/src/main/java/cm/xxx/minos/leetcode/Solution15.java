package cm.xxx.minos.leetcode;


import cm.xxx.minos.sort.PrintTools;

/**
 * Author: lishangmin
 * Created: 2018-08-23 10:16
 */
public class Solution15 {

    public int removeElement(int[] nums, int val) {
        int n = 0 , m = nums.length;
        while (n < m){
            if(nums[n] == val){
                nums[n] = nums[--m];
            }else {
                n++;
            }
        }
        PrintTools.arrayPrint(nums,n,m);
        return n;
    }


    public static void main(String[] args) {
        Solution15 solution = new Solution15();
        int[] nums = {1,1,3,3,3};
        int sum = solution.removeElement(nums,3);
        System.out.println(sum);
    }

}
