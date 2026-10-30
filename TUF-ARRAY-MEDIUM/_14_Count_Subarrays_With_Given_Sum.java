
import java.util.*;

public class _14_Count_Subarrays_With_Given_Sum {

    public static int countSubarrays(int[] arr, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);

        int prefixSum = 0;
        int count = 0;

        for (int num : arr) {

            prefixSum += num;

            int remaining = prefixSum - k;

            count += map.getOrDefault(remaining, 0);

            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {

        // Test Case 1
        int[] arr1 = { 1, 1, 1 };
        int k1 = 2;

        System.out.println("Test Case 1:");
        System.out.println("Input  : " + Arrays.toString(arr1));
        System.out.println("Target : " + k1);
        System.out.println("Output : " + countSubarrays(arr1, k1));
        System.out.println();

        // Test Case 2
        int[] arr2 = { 1, 2, 3 };
        int k2 = 3;

        System.out.println("Test Case 2:");
        System.out.println("Input  : " + Arrays.toString(arr2));
        System.out.println("Target : " + k2);
        System.out.println("Output : " + countSubarrays(arr2, k2));
        System.out.println();

        // Test Case 3
        int[] arr3 = { 1, 2, 1, 2, 1 };
        int k3 = 3;

        System.out.println("Test Case 3:");
        System.out.println("Input  : " + Arrays.toString(arr3));
        System.out.println("Target : " + k3);
        System.out.println("Output : " + countSubarrays(arr3, k3));
        System.out.println();

        // Test Case 4
        int[] arr4 = { 1, -1, 0 };
        int k4 = 0;

        System.out.println("Test Case 4:");
        System.out.println("Input  : " + Arrays.toString(arr4));
        System.out.println("Target : " + k4);
        System.out.println("Output : " + countSubarrays(arr4, k4));
        System.out.println();

        // Test Case 5
        int[] arr5 = { 3, 4, 7, 2, -3, 1, 4, 2 };
        int k5 = 7;

        System.out.println("Test Case 5:");
        System.out.println("Input  : " + Arrays.toString(arr5));
        System.out.println("Target : " + k5);
        System.out.println("Output : " + countSubarrays(arr5, k5));
        System.out.println();

        // Test Case 6
        int[] arr6 = {};
        int k6 = 0;

        System.out.println("Test Case 6:");
        System.out.println("Input  : " + Arrays.toString(arr6));
        System.out.println("Target : " + k6);
        System.out.println("Output : " + countSubarrays(arr6, k6));
        System.out.println();
    }
}
