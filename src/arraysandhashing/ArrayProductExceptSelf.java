package arraysandhashing;

/*
    Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
    The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
    You must write an algorithm that runs in O(n) time and without using the division operation.

    Example 1:
        Input: nums = [1,2,3,4]
        Output: [24,12,8,6]
    Example 2:
        Input: nums = [-1,1,0,-3,3]
        Output: [0,0,9,0,0]
    Constraints:
        2 <= nums.length <= 105
        -30 <= nums[i] <= 30
        The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 */

public class ArrayProductExceptSelf {
    int[] nums = {1, 2, 3, 4}; // [24, 12, 8, 6]

    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int prefix = 1, postfix = 1;

        for(int i =0; i< nums.length; i++){
            res[i] = prefix; // [1, 1, 2, 6]
            prefix *= nums[i];
        }

        for(int j = nums.length-1; j >= 0; j--){
            res[j] *= postfix; // [24, 12, 8, 6]
            postfix *= nums[j];
        }
        return res;
    }
    public static void main(String[] args) {
        ArrayProductExceptSelf apes = new ArrayProductExceptSelf();

        int[] output = apes.productExceptSelf(apes.nums);

        for (int i = 0; i < output.length; i++) {
            System.out.println(output[i]);
        }
    }

}
