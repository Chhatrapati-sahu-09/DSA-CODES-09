import java.util.*;

public class _11_Reverse_Pairs {

    public static long bruteForce(int[] nums) {
        int n = nums.length;
        long count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((long) nums[i] > 2L * nums[j]) {
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
        count += countPairs(nums, left, mid, right);
        merge(nums, temp, left, mid, right);
        return count;
    }

    private static long countPairs(int[] nums, int left, int mid, int right) {
        long count = 0;
        int j = mid + 1;

        for (int i = left; i <= mid; i++) {
            while (j <= right && (long) nums[i] > 2L * nums[j]) {
                j++;
            }
            count += j - (mid + 1);
        }

        return count;
    }

    private static void merge(int[] nums, int[] temp, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
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
    }

    public static void main(String[] args) {
        int[] nums1 = { 1, 3, 2, 3, 1 };
        int[] nums2 = { 2, 4, 3, 5, 1 };
        int[] nums3 = { 1, 3, 2, 3, 1 };
        int[] nums4 = { 2, 4, 3, 5, 1 };

        System.out.println(bruteForce(nums1));
        System.out.println(bruteForce(nums2));
        System.out.println(optimal(nums3));
        System.out.println(optimal(nums4));
    }
}
