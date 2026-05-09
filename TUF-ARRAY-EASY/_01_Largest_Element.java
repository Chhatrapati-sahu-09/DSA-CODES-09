class _01_Largest_Element {
    public static void main(String[] args) {

        // Declare and initialize the array
        int[] arr = { 10, 45, 23, 89, 67 };

        // Assume first element is the largest initially
        int max = arr[0];

        // Loop through the array starting from index 1
        for (int i = 1; i < arr.length; i++) {

            // Compare current element with max
            if (arr[i] > max) {

                // If current element is greater, update max
                max = arr[i];
            }
        }

        // Print the largest element
        System.out.println("Largest element is: " + max);
    }
}