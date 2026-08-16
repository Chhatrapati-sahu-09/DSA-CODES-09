import java.util.HashMap;

class _14_Longest_Subarray_K {

    // Function to find longest subarray with sum 0
    public static int maxLen(int[] arr) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        int maxLen = 0;

        for (int i = 0; i < arr.length; i++) {

            // Add current element
            sum += arr[i];

            // If sum becomes 0
            if (sum == 0) {

                maxLen = i + 1;
            }

            // If same prefix sum already exists
            if (map.containsKey(sum)) {

                int len = i - map.get(sum);

                maxLen = Math.max(maxLen, len);
            }

            // Store first occurrence only
            else {

                map.put(sum, i);
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {

        int[] arr = { 15, -2, 2, -8, 1, 7, 10, 23 };

        int ans = maxLen(arr);

        System.out.println("Longest Length = " + ans);
    }
}