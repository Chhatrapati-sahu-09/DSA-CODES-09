class _05_Left_Rotate_By_One {
    public static void main(String[] args) {

        int arr[] = { 1, 2, 3, 4, 5 };
        int n = arr.length;

        // Store first element
        int temp = arr[0];

        // Shift elements to left
        for (int i = 0; i < n - 1; i++) {
            arr[i] = arr[i + 1];
        }

        // Place first element at last
        arr[n - 1] = temp;

        // Print result
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}