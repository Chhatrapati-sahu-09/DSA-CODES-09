import java.util.*;

public class _03_3_Sum {

    // Brute Force: Check all combinations using 3 loops and a Set to filter duplicates.
    // Time Complexity: O(N^3 * log(unique_triplets))
    // Space Complexity: O(2 * unique_triplets) to store unique triplets
    public static List<List<Integer>> bruteForce(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k]);
                        Collections.sort(temp);
                        set.add(temp);
                    }
                }
            }
        }

        return new ArrayList<>(set);
    }

    // Better Approach: 2 loops + HashSet for lookups.
    // Time Complexity: O(N^2 * log(unique_triplets))
    // Space Complexity: O(N) for hashset + O(2 * unique_triplets)
    public static List<List<Integer>> better(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            Set<Integer> hashset = new HashSet<>();
            for (int j = i + 1; j < n; j++) {
                int third = -(nums[i] + nums[j]);
                if (hashset.contains(third)) {
                    List<Integer> temp = Arrays.asList(nums[i], nums[j], third);
                    Collections.sort(temp);
                    set.add(temp);
                }
                hashset.add(nums[j]);
            }
        }

        return new ArrayList<>(set);
    }

    // Optimal Approach: Sort + 2 pointers.
    // Time Complexity: O(N log N + N^2) = O(N^2)
    // Space Complexity: O(1) auxiliary space (excluding the output list)
    public static List<List<Integer>> optimal(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {
            // Remove duplicates for the first element
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int j = i + 1;
            int k = n - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k]);
                    ans.add(temp);
                    j++;
                    k--;

                    // Skip duplicates for the second and third elements
                    while (j < k && nums[j] == nums[j - 1]) j++;
                    while (j < k && nums[k] == nums[k + 1]) k--;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        int[] nums2 = {0, 1, 1};
        int[] nums3 = {0, 0, 0};

        System.out.println("--- 3-Sum Results ---");
        System.out.println("Brute Force:");
        System.out.println("nums1: " + bruteForce(nums1));
        System.out.println("nums2: " + bruteForce(nums2));
        System.out.println("nums3: " + bruteForce(nums3));

        System.out.println("\nBetter Approach:");
        System.out.println("nums1: " + better(nums1));
        System.out.println("nums2: " + better(nums2));
        System.out.println("nums3: " + better(nums3));

        System.out.println("\nOptimal Approach:");
        System.out.println("nums1: " + optimal(nums1));
        System.out.println("nums2: " + optimal(nums2));
        System.out.println("nums3: " + optimal(nums3));
    }
}
