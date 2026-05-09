class _13_Longest_Subarray_Positive_K {

    // ---------------- BRUTE FORCE ----------------
    // Time Complexity: O(N^2)
    public static int bruteForce(int[] arr, int k) {

        int maxLen = 0;

        for (int i = 0; i < arr.length; i++) {

            int sum = 0;

            for (int j = i; j < arr.length; j++) {

                sum += arr[j];

                if (sum == k) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }

        return maxLen;
    }

    // ---------------- OPTIMAL (Sliding Window) ----------------
    // Works only for Positive Numbers
    // Time Complexity: O(N)

    public static int optimal(int[] arr, int k) {

        int left = 0;
        int sum = 0;
        int maxLen = 0;

        for (int right = 0; right < arr.length; right++) {

            sum += arr[right];

            while (sum > k) {
                sum -= arr[left];
                left++;
            }

            if (sum == k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {

        int[] nums = { 10, 5, 2, 7, 1, 9 };
        int k = 15;

        System.out.println("Brute Force Answer: " + bruteForce(nums, k));
        System.out.println("Optimal Answer: " + optimal(nums, k));
    }
}