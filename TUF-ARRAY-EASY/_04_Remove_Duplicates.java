class _04_Remove_Duplicates {
    public static void main(String[] args) {

        // Sorted input array
        int[] arr = { 1, 1, 2, 2, 2, 3, 3 };

        int n = arr.length;

        // Edge case
        if (n == 0) {
            System.out.println("Unique count: 0");
            return;
        }

        // i points to last unique element
        int i = 0;

        // Traverse array
        for (int j = 1; j < n; j++) {

            // If new unique element found
            if (arr[j] != arr[i]) {

                i++; // move pointer forward
                arr[i] = arr[j]; // place unique element
            }
        }

        // Number of unique elements
        int uniqueCount = i + 1;

        // Print result array format
        System.out.print("Output: [");
        for (int k = 0; k < n; k++) {
            if (k < uniqueCount) {
                System.out.print(arr[k]);
            } else {
                System.out.print("_");
            }
            if (k != n - 1)
                System.out.print(",");
        }
        System.out.println("]");

        System.out.println("Unique count: " + uniqueCount);
    }
}
