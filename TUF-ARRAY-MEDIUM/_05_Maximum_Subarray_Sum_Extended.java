public class _05_Maximum_Subarray_Sum_Extended {

    public static void maximumSubarraySum(int[] arr) {
        int maxSum = arr[0];
        int currentSum = 0;

        int start = 0;
        int ansStart = 0;
        int ansEnd = 0;

        for (int i = 0; i < arr.length; i++) {

            if (currentSum == 0) {
                start = i;
            }

            currentSum += arr[i];

            if (currentSum > maxSum) {
                maxSum = currentSum;
                ansStart = start;
                ansEnd = i;
            }

            if (currentSum < 0) {
                currentSum = 0;
            }
        }

        System.out.println("Maximum Subarray Sum = " + maxSum);

        System.out.print("Subarray = [ ");
        for (int i = ansStart; i <= ansEnd; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        int[] arr = { -2, -3, 4, -1, -2, 1, 5, -3 };

        maximumSubarraySum(arr);
    }
}