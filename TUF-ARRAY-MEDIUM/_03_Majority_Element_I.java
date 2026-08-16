import java.util.Arrays;
import java.util.HashMap;

public class _03_Majority_Element_I {

    // Brute Force Approach
    public static int bruteForce(int[] nums) {

        int n = nums.length;

        for (int i = 0; i < n; i++) {

            int count = 0;

            for (int j = 0; j < n; j++) {

                if (nums[i] == nums[j]) {
                    count++;
                }
            }

            if (count > n / 2) {
                return nums[i];
            }
        }

        return -1;
    }

    // Better Approach (HashMap)
    public static int better(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int n = nums.length;

        for (int key : map.keySet()) {

            if (map.get(key) > n / 2) {
                return key;
            }
        }

        return -1;
    }

    // Optimal Approach (Moore's Voting Algorithm)
    public static int optimal(int[] nums) {

        int candidate = 0;
        int count = 0;

        for (int num : nums) {

            if (count == 0) {
                candidate = num;
            }

            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        return candidate;
    }

    public static void main(String[] args) {

        int[][] testCases = {
                { 7, 0, 0, 1, 7, 7, 2, 7, 7 },
                { 1, 1, 1, 2, 1, 2 },
                { 3, 3, 4 },
                { 2, 2, 1, 1, 1, 2, 2 },
                { 5 },
                { 6, 6, 6, 7, 7 },
                { 8, 8, 8, 8, 2, 3, 4 },
                { 9, 1, 9, 2, 9, 3, 9 },
                { 10, 10, 10, 10, 5, 6, 7 },
                { 4, 4, 4, 4, 4, 2, 2, 1 }
        };

        for (int i = 0; i < testCases.length; i++) {

            int[] nums = testCases[i];

            System.out.println("=================================");
            System.out.println("Test Case " + (i + 1));
            System.out.println("Array      : " + Arrays.toString(nums));

            System.out.println("Brute      : " + bruteForce(nums));
            System.out.println("Better     : " + better(nums));
            System.out.println("Optimal    : " + optimal(nums));
        }
    }
}