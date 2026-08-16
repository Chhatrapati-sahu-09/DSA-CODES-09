import java.util.Arrays;

public class _07_Rearrange_Array_Elements_By_Sign {

    // Approach 1: Using pos[] and neg[] arrays
    public static int[] rearrangeBrute(int[] nums) {
        int n = nums.length;

        int[] pos = new int[n / 2];
        int[] neg = new int[n / 2];

        int p = 0;
        int ng = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                pos[p++] = nums[i];
            } else {
                neg[ng++] = nums[i];
            }
        }

        for (int i = 0; i < n / 2; i++) {
            nums[2 * i] = pos[i];
            nums[2 * i + 1] = neg[i];
        }

        return nums;
    }

    // Approach 2: Optimal
    public static int[] rearrangeOptimal(int[] nums) {
        int n = nums.length;

        int[] ans = new int[n];

        int posIndex = 0;
        int negIndex = 1;

        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                ans[posIndex] = nums[i];
                posIndex += 2;
            } else {
                ans[negIndex] = nums[i];
                negIndex += 2;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] arr1 = { 1, 2, -4, -5 };
        int[] arr2 = { 3, 1, -2, -5, 2, -4 };

        System.out.println("===== BRUTE FORCE APPROACH =====");
        System.out.println("Input  : " + Arrays.toString(arr1));
        System.out.println("Output : " +
                Arrays.toString(rearrangeBrute(arr1.clone())));

        System.out.println();

        System.out.println("===== OPTIMAL APPROACH =====");
        System.out.println("Input  : " + Arrays.toString(arr2));
        System.out.println("Output : " +
                Arrays.toString(rearrangeOptimal(arr2)));

    }
}