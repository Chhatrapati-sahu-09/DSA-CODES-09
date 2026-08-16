import java.util.*;

public class _12_Maximum_Product_Subarray {

    public static int bruteForce(int[] nums) {
        int n = nums.length;
        int maxProduct = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int product = 1;
            for (int j = i; j < n; j++) {
                product *= nums[j];
                maxProduct = Math.max(maxProduct, product);
            }
        }

        return maxProduct;
    }

    public static int optimal(int[] nums) {
        int n = nums.length;
        int maxProduct = Integer.MIN_VALUE;
        int prefix = 1;
        int suffix = 1;

        for (int i = 0; i < n; i++) {
            prefix = (prefix == 0 ? 1 : prefix) * nums[i];
            suffix = (suffix == 0 ? 1 : suffix) * nums[n - 1 - i];
            maxProduct = Math.max(maxProduct, Math.max(prefix, suffix));
        }

        return maxProduct;
    }

    public static void main(String[] args) {
        int[] nums1 = { 2, 3, -2, 4 };
        int[] nums2 = { -2, 0, -1 };
        int[] nums3 = { 2, 3, -2, 4 };
        int[] nums4 = { -2, 0, -1 };

        System.out.println(bruteForce(nums1));
        System.out.println(bruteForce(nums2));
        System.out.println(optimal(nums3));
        System.out.println(optimal(nums4));
    }
}
