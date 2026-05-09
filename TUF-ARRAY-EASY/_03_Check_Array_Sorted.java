class _03_Check_Array_Sorted {
    public static void main(String[] args) {

        // Declare and initialize array
        int[] arr = { 10, 20, 30, 40, 50 };

        // Assume array is sorted initially
        boolean isSorted = true;

        // Traverse array and compare adjacent elements
        for (int i = 0; i < arr.length - 1; i++) {

            // If current element is greater than next → not sorted
            if (arr[i] > arr[i + 1]) {
                isSorted = false;
                break; // no need to check further
            }
        }

        // Print result
        if (isSorted) {
            System.out.println("Array is sorted");
        } else {
            System.out.println("Array is not sorted");
        }
    }
}