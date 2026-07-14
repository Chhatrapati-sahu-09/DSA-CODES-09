import java.util.*;

public class _05_Largest_Subarray_With_Sum_0 {

    // Brute Force: Check all subarrays.
    // Time Complexity: O(N^2)
    // Space Complexity: O(1)
    public static int bruteForce(int[] nums) {
        int n = nums.length;
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (sum == 0) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }

        return maxLen;
    }

    // Optimal Approach: Using Hashing of Prefix Sums.
    // Time Complexity: O(N)
    // Space Complexity: O(N) to store prefix sums in HashMap
    public static int optimal(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxLen = 0;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];

            if (sum == 0) {
                maxLen = i + 1;
            } else {
                if (map.containsKey(sum)) {
                    maxLen = Math.max(maxLen, i - map.get(sum));
                } else {
                    map.put(sum, i);
                }
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] nums1 = {15, -2, 2, -8, 1, 7, 10, 23};
        int[] nums2 = {2, 10, 4};
        int[] nums3 = {1, 0, -4, 3, 1, 0};

        System.out.println("--- Largest Subarray with Sum 0 Results ---");
        System.out.println("Brute Force:");
        System.out.println("nums1: " + bruteForce(nums1) + " (Expected: 5)");
        System.out.println("nums2: " + bruteForce(nums2) + " (Expected: 0)");
        System.out.println("nums3: " + bruteForce(nums3) + " (Expected: 5)");

        System.out.println("\nOptimal Approach:");
        System.out.println("nums1: " + optimal(nums1) + " (Expected: 5)");
        System.out.println("nums2: " + optimal(nums2) + " (Expected: 0)");
        System.out.println("nums3: " + optimal(nums3) + " (Expected: 5)");
    }
}
