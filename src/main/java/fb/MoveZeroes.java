package fb;

import java.util.Arrays;

/**
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *
 * Example:
 *
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 *
 * Note:
 *
 *     You must do this in-place without making a copy of the array.
 *     Minimize the total number of operations.
 */

public class MoveZeroes {

    public static void moveZeroes(int[] nums) {
        if(nums.length <= 0) return;
        int N = nums.length;
        int index = 0;
        int isZeroPointer = 0;

        while (isZeroPointer < N) {
            if (nums[isZeroPointer] != 0) {
                int temp = nums[isZeroPointer];
                nums[isZeroPointer] = 0;
                nums[index] = temp;
                index++;
            }
            isZeroPointer++;
        }

    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        //moveZeroes(nums);
        Arrays.stream(nums).forEach(t ->
                System.out.println(t));

    }
}
