class _09_Union_Two_Sorted_Arrays {

    public static void main(String[] args) {

        int arr1[] = { 1, 2, 2, 3, 4 };
        int arr2[] = { 2, 3, 5 };

        int n = arr1.length;
        int m = arr2.length;

        int union[] = new int[n + m];
        int i = 0, j = 0, k = 0;

        while (i < n && j < m) {

            if (arr1[i] < arr2[j]) {

                if (k == 0 || union[k - 1] != arr1[i]) {

                    union[k++] = arr1[i];

                }

                i++;

            } else if (arr1[i] > arr2[j]) {

                if (k == 0 || union[k - 1] != arr1[j]) {

                    union[k++] = arr1[j];

                }

                j++;

            } else {

                if (k == 0 || union[k - 1] != arr1[i]) {

                    union[k++] = arr1[i];

                }

                i++;
                j++;

            }
        }

        while (i < n) {

            if (k == 0 || union[k - 1] != arr1[i]) {
                union[k++] = arr1[i];
            }
            i++;

        }

        while (j < m) {
            if (k == 0 || union[k - 1] != arr2[j]) {
                union[k++] = arr2[j];
            }
            j++;
        }

        // Print result (only first k elements are valid)
        for (int x = 0; x < k; x++) {
            System.out.print(union[x] + " ");
        }
    }
}