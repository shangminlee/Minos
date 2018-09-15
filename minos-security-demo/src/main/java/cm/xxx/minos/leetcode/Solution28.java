package cm.xxx.minos.leetcode;


/**
 * 是否有重复数据
 * Author: lishangmin
 * Created: 2018-08-23 10:16
 */
public class Solution28 {

    public int singleNumber(int[] nums) {
        int result = 0;
//        for (int n: nums) {
//            if(result > n){
//                result = result + n;
//            }else {
//                result = result - n;
//            }
//            System.out.println(result);
//        }
        for (int n: nums) {
//            try{
//                Thread.sleep(1000);
//            }catch (Exception ignored){
//
//            }
            //System.out.printf("%6d ^ %-6d %n",result ,n);
            System.out.printf("%32s%n%32s ^%n",Integer.toBinaryString(result) ,Integer.toBinaryString(n));
            System.out.println("-------------------------------------------------");
            result = result ^ n;
            System.out.printf("%32s%n%n%n",Integer.toBinaryString(result));
        }
        System.out.println("");
        return result;
    }

    public static void main(String[] args) {
        Solution28 solution = new Solution28();
        int[] nums = {4,1,3,1,3};
        int s = solution.singleNumber(nums);
        System.out.println(s);

        int v = 1;

        v += v+=2;
        System.out.println(v);
    }

}
