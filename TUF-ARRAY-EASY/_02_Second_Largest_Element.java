class _02_Second_Largest_Element {
    public static void main(String[] args) {

        // Declare and initialize array
        int[] arr = { 10, 45, 23, 89, 67 };

        // Edge case: if array has less than 2 elements
        if (arr.length < 2) {
            System.out.println("Second largest element not possible");
            return;
        }

        // Initialize largest and second largest
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        // Traverse the array
        for (int i = 0; i < arr.length; i++) {

            // If current element is greater than largest
            if (arr[i] > largest) {

                // Update second largest before updating largest
                secondLargest = largest;

                // Update largest
                largest = arr[i];
            }

            // If current element is smaller than largest
            // but greater than second largest
            else if (arr[i] > secondLargest && arr[i] != largest) {

                // Update second largest
                secondLargest = arr[i];
            }
        }

        // Check if second largest exists
        if (secondLargest == Integer.MIN_VALUE) {
            System.out.println("No second largest element (all elements same)");
        } else {
            System.out.println("Second largest element is: " + secondLargest);
        }
    }
}