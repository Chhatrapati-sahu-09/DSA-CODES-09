import java.util.Arrays;

public class _08_Next_Permutation {

    public static void nextPermutation(int[] nums) {

        int n = nums.length;
        int pivot = -1;

        // Step 1: Find Pivot
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                pivot = i;
                break;
            }
        }

        // Step 2: If no pivot, reverse whole array
        if (pivot == -1) {
            reverse(nums, 0, n - 1);
            return;
        }

        // Step 3: Find next greater element from right
        for (int i = n - 1; i > pivot; i--) {
            if (nums[i] > nums[pivot]) {
                swap(nums, i, pivot);
                break;
            }
        }

        // Step 4: Reverse suffix
        reverse(nums, pivot + 1, n - 1);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }

    private static void test(int[] arr) {
        System.out.println("Input  : " + Arrays.toString(arr));
        nextPermutation(arr);
        System.out.println("Output : " + Arrays.toString(arr));
        System.out.println();
    }

    public static void main(String[] args) {

        test(new int[] { 1, 2, 3 }); // [1,3,2]

        test(new int[] { 3, 2, 1 }); // [1,2,3]

        test(new int[] { 1, 1, 5 }); // [1,5,1]

        test(new int[] { 1, 3, 2 }); // [2,1,3]

        test(new int[] { 1, 2, 3, 6, 5, 4 }); // [1,2,4,3,5,6]

        test(new int[] { 2, 1, 5, 4, 3, 0, 0 }); // [2,3,0,0,1,4,5]
    }
}