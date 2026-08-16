import java.util.Arrays;

public class _02_Sort_Array_Of_0s_1s_And_2s {

    // Brute Force Approach (Simple Sorting)
    public static void bruteForce(int[] nums) {

        int n = nums.length;

        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j < n; j++) {

                if (nums[i] > nums[j]) {

                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }

    // Optimal Approach (Dutch National Flag Algorithm)
    public static void optimal(int[] nums) {

        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {

            if (nums[mid] == 0) {

                swap(nums, low, mid);
                low++;
                mid++;
            }

            else if (nums[mid] == 1) {

                mid++;
            }

            else { // nums[mid] == 2

                swap(nums, mid, high);
                high--;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {

        int[][] testCases = {
                { 1, 0, 2, 1, 0 },
                { 0, 0, 1, 1, 1 },
                { 2, 1, 0, 2, 1, 0 },
                { 2, 2, 2, 1, 1, 0, 0 },
                { 0, 1, 2 },
                { 2, 0, 1 },
                { 0, 0, 0 },
                { 1, 1, 1 },
                { 2, 2, 2 },
                { 2, 0, 2, 1, 1, 0 }
        };

        for (int i = 0; i < testCases.length; i++) {

            int[] bruteArray = testCases[i].clone();
            int[] optimalArray = testCases[i].clone();

            bruteForce(bruteArray);
            optimal(optimalArray);

            System.out.println("=================================");
            System.out.println("Test Case " + (i + 1));
            System.out.println("Original Array : "
                    + Arrays.toString(testCases[i]));

            System.out.println("Brute Force    : "
                    + Arrays.toString(bruteArray));

            System.out.println("Optimal        : "
                    + Arrays.toString(optimalArray));
        }
    }
}