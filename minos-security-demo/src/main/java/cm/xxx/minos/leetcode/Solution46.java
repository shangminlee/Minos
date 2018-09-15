package cm.xxx.minos.leetcode;


/**
 * li
 * Author: lishangmin
 * Created: 2018-08-23 10:16
 */
public class Solution46 {

    public int arrayPairSum(int[] nums) {
        int[] index = new int[20001];
        for (int i = 0; i < nums.length ; i++) {
            index[nums[i] + 10000]++;
        }
        int sum = 0;
        boolean odd = true;
        for (int i = 0; i < index.length ; i++) {
            while (index[i] > 0){
                if(odd){
                    sum += i - 10000;
                }
                odd = !odd;
                index[i]--;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution46 solution = new Solution46();
        int[] nums = {1,4,3,2,5,6};
        System.out.println(solution.arrayPairSum(nums));
    }

}
