package fb;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        int[] intArray = new int[2];
        Map<Integer, Integer> arrayElement = new HashMap<>();
        for (int i=0;i<nums.length; i++ ) {
            int need = target - nums[i];
            if (arrayElement.containsKey(need)) {
                intArray[0] = arrayElement.get(need);
                intArray[1] = i;
                return intArray;
            }
            arrayElement.put(nums[i], i);
        }
        return intArray;

    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        Arrays.stream(twoSum(nums, target)).forEach( t-> System.out.println(t));
    }
}
