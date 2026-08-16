import java.util.*;

public class _09_Find_The_Repeating_And_Missing_Number {

    public static int[] bruteForce(int[] nums) {
        int n = nums.length;
        int[] freq = new int[n + 1];
        int repeating = -1;
        int missing = -1;

        for (int value : nums) {
            freq[value]++;
        }

        for (int value = 1; value <= n; value++) {
            if (freq[value] == 2) {
                repeating = value;
            } else if (freq[value] == 0) {
                missing = value;
            }
        }

        return new int[] { repeating, missing };
    }

    public static int[] optimal(int[] nums) {
        long n = nums.length;
        long sum = 0;
        long sumSquares = 0;

        for (int value : nums) {
            sum += value;
            sumSquares += (long) value * value;
        }

        long expectedSum = n * (n + 1) / 2;
        long expectedSumSquares = n * (n + 1) * (2 * n + 1) / 6;
        long diff = sum - expectedSum;
        long squareDiff = sumSquares - expectedSumSquares;
        long sumOfValues = squareDiff / diff;
        long repeating = (diff + sumOfValues) / 2;
        long missing = repeating - diff;

        return new int[] { (int) repeating, (int) missing };
    }

    private static String pairToString(int[] pair) {
        return Arrays.toString(pair);
    }

    public static void main(String[] args) {
        int[] nums1 = { 3, 1, 2, 5, 3 };
        int[] nums2 = { 4, 3, 6, 2, 1, 1 };

        System.out.println(pairToString(bruteForce(nums1)));
        System.out.println(pairToString(bruteForce(nums2)));
        System.out.println(pairToString(optimal(nums1)));
        System.out.println(pairToString(optimal(nums2)));
    }
}
