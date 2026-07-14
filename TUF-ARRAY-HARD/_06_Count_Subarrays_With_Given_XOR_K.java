import java.util.*;

public class _06_Count_Subarrays_With_Given_XOR_K {

    // Brute Force: Check all subarrays.
    // Time Complexity: O(N^2)
    // Space Complexity: O(1)
    public static int bruteForce(int[] nums, int k) {
        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            int xorSum = 0;
            for (int j = i; j < n; j++) {
                xorSum ^= nums[j];
                if (xorSum == k) {
                    count++;
                }
            }
        }

        return count;
    }

    // Optimal Approach: Using Prefix XOR and HashMap.
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public static int optimal(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        int xr = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // Initializing with prefix XOR 0 occurring once (for subarrays starting at index 0)
        map.put(0, 1);

        for (int i = 0; i < n; i++) {
            xr ^= nums[i];

            // Formula: Y = xr ^ k
            int target = xr ^ k;

            // Add the number of times target prefix XOR has occurred
            if (map.containsKey(target)) {
                count += map.get(target);
            }

            // Put/update the current prefix XOR in the map
            map.put(xr, map.getOrDefault(xr, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums1 = {4, 2, 2, 6, 4};
        int k1 = 6;

        int[] nums2 = {5, 6, 7, 8, 9};
        int k2 = 5;

        System.out.println("--- Count Subarrays with Given XOR K Results ---");
        System.out.println("Brute Force:");
        System.out.println("nums1 (k=6): " + bruteForce(nums1, k1) + " (Expected: 4)");
        System.out.println("nums2 (k=5): " + bruteForce(nums2, k2) + " (Expected: 2)");

        System.out.println("\nOptimal Approach:");
        System.out.println("nums1 (k=6): " + optimal(nums1, k1) + " (Expected: 4)");
        System.out.println("nums2 (k=5): " + optimal(nums2, k2) + " (Expected: 2)");
    }
}
