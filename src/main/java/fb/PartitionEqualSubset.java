package fb;

/**
 * Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
 *
 * Note:
 *
 *     Each of the array element will not exceed 100.
 *     The array size will not exceed 200.
 *
 *
 *
 * Example 1:
 *
 * Input: [1, 5, 11, 5]
 *
 * Output: true
 *
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 *
 *
 *
 * Example 2:
 *
 * Input: [1, 2, 3, 5]
 *
 * Output: false
 *
 * Explanation: The array cannot be partitioned into equal sum subsets.
 */
public class PartitionEqualSubset {

    public static boolean canPartition(int[] nums) {
        int total = 0;
        for(int num:nums) {
            total +=num;
        }

        if(total %2 !=0)  return false;

        return canPartition(nums,0,0,total);
    }

    public static boolean canPartition(int[] nums,int index, int sum, int total) {
        if (sum *2 == total ) return true;
        if(sum > total /2 || index >= nums.length) return false;
        return canPartition(nums,index+1,sum,total) || canPartition(nums,index+1,sum + nums[index],total);
    }

    public static void main(String[] args) {
        int [] nums = {1, 5, 11, 5};
        int [] nums1 = {1, 2, 3, 5};
        System.out.println(canPartition(nums1));
    }
}
