import java.util.*;

public class _01_Two_Sum {

    // Brute Force Approach
    public static int[] bruteForce(int[] nums, int target) {

        int n = nums.length;

        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j < n; j++) {

                if (nums[i] + nums[j] == target) {

                    return new int[] { i, j }; // return indices

                }
            }
        }

        return new int[] { -1, -1 };
    }

    // Optimal Approach
    public static int[] optimal(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int complement = target - nums[i];

            if (map.containsKey(complement)) {

                return new int[] { map.get(complement), i };

            }

            map.put(nums[i], i);

        }

        return new int[] { -1, -1 };
    }

    public static void main(String[] args) {

        int[] nums = { 2, 7, 11, 15 };
        int target = 9;

        System.out.println("Brute Force:");
        System.out.println(Arrays.toString(bruteForce(nums, target)));

        System.out.println("Optimal:");
        System.out.println(Arrays.toString(optimal(nums, target)));
    }
}