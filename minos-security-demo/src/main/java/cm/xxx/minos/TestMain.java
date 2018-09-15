package cm.xxx.minos;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;

/**
 * Description:
 * Author: lishangmin
 * Created: 2018-08-10 17:44
 */
@Slf4j
public class TestMain {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5};
        int target = 9;
        int[] result = twoSum(nums,target);
        log.info("{}",result);
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0 ; i < nums.length ; i++){
            int value = target - nums[i];
            if(map.containsKey(value)){
                return new int[]{nums[i],nums[map.get(value)]};
            }
            map.put(nums[i],i);
        }
        return null;
    }
}
