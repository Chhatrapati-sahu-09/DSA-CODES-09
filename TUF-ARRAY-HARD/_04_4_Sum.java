import java.util.*;

public class _04_4_Sum {

    // Brute Force: Check all combinations using 4 loops and a Set to filter duplicates.
    // Time Complexity: O(N^4 * log(unique_quadruplets))
    // Space Complexity: O(2 * unique_quadruplets) to store unique quadruplets
    public static List<List<Integer>> bruteForce(int[] nums, int target) {
        Set<List<Integer>> set = new HashSet<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    for (int l = k + 1; l < n; l++) {
                        // Using long to avoid overflow when summing up elements
                        long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];
                        if (sum == target) {
                            List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
                            Collections.sort(temp);
                            set.add(temp);
                        }
                    }
                }
            }
        }

        return new ArrayList<>(set);
    }

    // Better Approach: 3 loops + HashSet for lookups.
    // Time Complexity: O(N^3 * log(unique_quadruplets))
    // Space Complexity: O(N) for hashset + O(2 * unique_quadruplets)
    public static List<List<Integer>> better(int[] nums, int target) {
        Set<List<Integer>> set = new HashSet<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                Set<Long> hashset = new HashSet<>();
                for (int k = j + 1; k < n; k++) {
                    long sum = (long) nums[i] + nums[j] + nums[k];
                    long fourth = target - sum;
                    if (hashset.contains(fourth)) {
                        List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k], (int) fourth);
                        Collections.sort(temp);
                        set.add(temp);
                    }
                    hashset.add((long) nums[k]);
                }
            }
        }

        return new ArrayList<>(set);
    }

    // Optimal Approach: Sort + 2 nested loops + 2 pointers.
    // Time Complexity: O(N^3)
    // Space Complexity: O(1) auxiliary space (excluding the output list)
    public static List<List<Integer>> optimal(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {
            // Remove duplicates for the first element
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < n; j++) {
                // Remove duplicates for the second element
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                int k = j + 1;
                int l = n - 1;

                while (k < l) {
                    long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];
                    if (sum < target) {
                        k++;
                    } else if (sum > target) {
                        l--;
                    } else {
                        List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
                        ans.add(temp);
                        k++;
                        l--;

                        // Skip duplicates for the third and fourth elements
                        while (k < l && nums[k] == nums[k - 1]) k++;
                        while (k < l && nums[l] == nums[l + 1]) l--;
                    }
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 0, -1, 0, -2, 2};
        int target1 = 0;

        int[] nums2 = {2, 2, 2, 2, 2};
        int target2 = 8;

        System.out.println("--- 4-Sum Results ---");
        System.out.println("Brute Force:");
        System.out.println("nums1 (target 0): " + bruteForce(nums1, target1));
        System.out.println("nums2 (target 8): " + bruteForce(nums2, target2));

        System.out.println("\nBetter Approach:");
        System.out.println("nums1 (target 0): " + better(nums1, target1));
        System.out.println("nums2 (target 8): " + better(nums2, target2));

        System.out.println("\nOptimal Approach:");
        System.out.println("nums1 (target 0): " + optimal(nums1, target1));
        System.out.println("nums2 (target 8): " + optimal(nums2, target2));
    }
}
