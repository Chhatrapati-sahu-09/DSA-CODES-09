class _08_Linear_Search {

    // Function for linear search
    static int search(int arr[], int key) {

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == key) {
                return i; // element found
            }
        }

        return -1; // not found
    }

    public static void main(String[] args) {

        int arr[] = { 10, 20, 30, 40, 50 };
        int key = 30;

        int result = search(arr, key);

        if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found");
        }
    }
}