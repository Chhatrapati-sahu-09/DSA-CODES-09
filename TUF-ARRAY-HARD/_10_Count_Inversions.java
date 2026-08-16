import java.util.*;

public class _10_Count_Inversions {

    public static long bruteForce(int[] nums) {
        int n = nums.length;
        long count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] > nums[j]) {
                    count++;
                }
            }
        }

        return count;
    }

    public static long optimal(int[] nums) {
        int[] temp = new int[nums.length];
        return mergeSort(nums, temp, 0, nums.length - 1);
    }

    private static long mergeSort(int[] nums, int[] temp, int left, int right) {
        if (left >= right) {
            return 0;
        }

        int mid = left + (right - left) / 2;
        long count = 0;
        count += mergeSort(nums, temp, left, mid);
        count += mergeSort(nums, temp, mid + 1, right);
        count += merge(nums, temp, left, mid, right);
        return count;
    }

    private static long merge(int[] nums, int[] temp, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = left;
        long count = 0;

        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                count += mid - i + 1;
                temp[k++] = nums[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = nums[i++];
        }

        while (j <= right) {
            temp[k++] = nums[j++];
        }

        for (int index = left; index <= right; index++) {
            nums[index] = temp[index];
        }

        return count;
    }

    private static String arrayToString(int[] nums) {
        return Arrays.toString(nums);
    }

    public static void main(String[] args) {
        int[] nums1 = { 5, 3, 2, 1, 4 };
        int[] nums2 = { 1, 20, 6, 4, 5 };
        int[] nums3 = { 5, 3, 2, 1, 4 };
        int[] nums4 = { 1, 20, 6, 4, 5 };

        System.out.println(bruteForce(nums1));
        System.out.println(bruteForce(nums2));
        System.out.println(optimal(nums3));
        System.out.println(optimal(nums4));
        System.out.println(arrayToString(nums3));
        System.out.println(arrayToString(nums4));
    }
}
