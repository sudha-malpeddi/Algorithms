package arraysandhashing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
    Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
    You must write an algorithm that runs in O(n) time.

    Example 1:
        Input: nums = [100,4,200,1,3,2]
        Output: 4
        Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
    Example 2:
        Input: nums = [0,3,7,2,5,8,4,6,0,1]
        Output: 9

    Constraints:
        0 <= nums.length <= 105
        -109 <= nums[i] <= 109
*/
public class LongestConsecutiveSeq {
    public static boolean linearSearch(int[] arr, int num){
        for (int j : arr) {
            if (j == num)
                return true;
        }
        return false;
    }

    // time complexity - O(n^3) & space complexity - O(1)
    public static int bruteForceLongestConsecutiveSeq(int[] nums) {
        int longest = 1;

        for (int num : nums) {
            int x = num;
            int count = 1;
            while (linearSearch(nums, x + 1)) {
                count++;
                x = x + 1;
            }
            longest = Math.max(longest, count);
        }
        return longest;
    }

    // time complexity - O(nlogn) & space complexity - O(1)
    public static int betterLongestConsecutiveSeq(int[] nums){
        int n = nums.length;
        if(n == 0)
            return 0;

        Arrays.sort(nums);
        int longest = 1;
        int lastSmaller = Integer.MIN_VALUE;
        int count = 0;

        for (int num : nums) {
            if (num - 1 == lastSmaller) {
                count++;
                lastSmaller = num;
            } else if (num != lastSmaller) {
                count = 1;
                lastSmaller = num;
            }
            longest = Math.max(longest, count);
        }

        return longest;
    }

    //time complexity - O(n) & space complexity - O(n)
    public static int optimalLongestConsecutiveSeq(int[] nums){
        int n = nums.length;
        if(n == 0)
            return 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int longest = 1;
        int count;

        for(int it : set){
            if(!set.contains(it-1)){
                count = 1;
                int x = it;
                while(set.contains(x+1)){
                    count++;
                    x = x+1;
                }
                longest = Math.max(longest, count);
            }
        }

        return longest;
    }

    public static void main(String[] args) {
        int[] a = {100, 200, 1, 2, 3, 4,5, 6, 1, 1, 2, 3};
        int ans1 = bruteForceLongestConsecutiveSeq(a);
        int ans2 = betterLongestConsecutiveSeq(a);
        int ans3 = optimalLongestConsecutiveSeq(a);
        System.out.println("The longest consecutive sequence by brute-force approach is " + ans1);
        System.out.println("The longest consecutive sequence by better approach is " + ans2);
        System.out.println("The longest consecutive sequence by optimal approach is " + ans3);
    }
}
