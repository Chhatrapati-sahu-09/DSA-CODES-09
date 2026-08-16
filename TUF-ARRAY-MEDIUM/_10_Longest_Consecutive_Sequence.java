import java.util.*;

public class _10_Longest_Consecutive_Sequence {

    public static int longestConsecutive(int[] arr) {

        HashSet<Integer> set = new HashSet<>();

        for (int num : arr) {
            set.add(num);
        }

        int longest = 0;

        for (int num : arr) {

            if (!set.contains(num - 1)) {

                int currentsum = num;
                int count = 1;

                while (set.contains(currentsum + 1)) {
                    currentsum++;
                    count++;
                }

                longest = Math.max(longest, count);
            }
        }

        return longest;
    }

    public static void main(String[] args) {

        // Test Case 1
        int[] arr1 = { 100, 4, 200, 1, 3, 2 };
        System.out.println("Test Case 1:");
        System.out.println("Input  : " + Arrays.toString(arr1));
        System.out.println("Output : " + longestConsecutive(arr1));
        System.out.println();

        // Test Case 2
        int[] arr2 = { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 };
        System.out.println("Test Case 2:");
        System.out.println("Input  : " + Arrays.toString(arr2));
        System.out.println("Output : " + longestConsecutive(arr2));
        System.out.println();

        // Test Case 3
        int[] arr3 = { 1, 2, 0, 1 };
        System.out.println("Test Case 3:");
        System.out.println("Input  : " + Arrays.toString(arr3));
        System.out.println("Output : " + longestConsecutive(arr3));
        System.out.println();

        // Test Case 4
        int[] arr4 = { 9, 1, 4, 7, 3, -1, 0, 5, 8, -1, 6 };
        System.out.println("Test Case 4:");
        System.out.println("Input  : " + Arrays.toString(arr4));
        System.out.println("Output : " + longestConsecutive(arr4));
        System.out.println();

        // Test Case 5
        int[] arr5 = {};
        System.out.println("Test Case 5:");
        System.out.println("Input  : " + Arrays.toString(arr5));
        System.out.println("Output : " + longestConsecutive(arr5));
        System.out.println();

        // Test Case 6
        int[] arr6 = { 5 };
        System.out.println("Test Case 6:");
        System.out.println("Input  : " + Arrays.toString(arr6));
        System.out.println("Output : " + longestConsecutive(arr6));
        System.out.println();
    }
}