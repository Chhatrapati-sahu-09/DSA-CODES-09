class _07_Move_Zeros_To_End {

    // Function to move zeros to end
    static void moveZeros(int arr[]) {

        int j = 0; // position for next non-zero

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] != 0) {

                // swap arr[i] with arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                j++;
            }
        }
    }

    // Print function
    static void print(int arr[]) {
        for (int x : arr) {
            System.out.print(x + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int arr[] = { 1, 0, 2, 3, 0, 4, 0, 1 };

        moveZeros(arr);

        System.out.print("Output: ");
        print(arr);
    }
}