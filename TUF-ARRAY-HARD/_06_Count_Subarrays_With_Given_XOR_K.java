import java.util.*;

public class _06_Count_Subarrays_With_Given_XOR_K {

    public static int bruteForce(int[] nums, int k) {
        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            int xorSum = 0;
            for (int j = i; j < n; j++) {
                xorSum ^= nums[j];
                if (xorSum == k) {
                    count++;
                }
            }
        }

        return count;
    }

    public static int optimal(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        int xr = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);

        for (int i = 0; i < n; i++) {
            xr ^= nums[i];

            int target = xr ^ k;

            if (map.containsKey(target)) {
                count += map.get(target);
            }

            map.put(xr, map.getOrDefault(xr, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums1 = { 4, 2, 2, 6, 4 };
        int k1 = 6;

        int[] nums2 = { 5, 6, 7, 8, 9 };
        int k2 = 5;

        System.out.println(bruteForce(nums1, k1));
        System.out.println(bruteForce(nums2, k2));
        System.out.println(optimal(nums1, k1));
        System.out.println(optimal(nums2, k2));
    }
}
