package cm.xxx.minos.leetcode;


import cm.xxx.minos.sort.PrintTools;

/**
 * Author: lishangmin
 * Created: 2018-08-23 10:16
 */
public class Solution16 {

    public int removeElement(int[] nums, int val) {
        int i = 0 , n = 0;
        while (i < nums.length){
            try{
                Thread.sleep(500);
            }catch (Exception e){

            }
            PrintTools.arrayPrint(nums,i,n);
            if(nums[i] != val) {
                nums[n++] = nums[i];
            }
            i++;
        }
        PrintTools.arrayPrint(nums,i,n);
        return n-1;
    }


    public static void main(String[] args) {
        Solution16 solution = new Solution16();
        int[] nums = {1,1,3,3,3};
        int sum = solution.removeElement(nums,3);
        System.out.println(sum);
    }

}
