package cm.xxx.minos.leetcode;


/**
 * Author: lishangmin
 * Created: 2018-08-23 10:16
 */
public class Solution13 {

    public int removeDuplicates(int[] nums) {
        int i = 0 ;
        int j = nums.length - 1;
        while (i <= j){
            int n = i + 1;
            while (n <= j){
                if(nums[i] == nums[n]){
                    n++;
                }else {
                    break;
                }
            }
            n = n - i - 1;
            if(n >= 1) {
                int m = i + 1;
                int x = i + n + 1;
                while (x <= j) {
                    nums[m] = nums[x];
                    m++;
                    x++;
                }
                j = j - n;
            }
            i++;
        }
        return j + 1;
    }


    public static void main(String[] args) {
        Solution13 solution = new Solution13();
        int[] nums = {1,1,2,2,3,3,3,3,4,5,5,6};
        int sum = solution.removeDuplicates(nums);
        System.out.println(sum);
    }

}
