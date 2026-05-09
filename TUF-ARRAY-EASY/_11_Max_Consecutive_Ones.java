class _11_Max_Consecutive_Ones {

    public static void main(String[] args) {

        int arr[] = { 1, 1, 0, 1, 1, 1 };

        int count = 0;
        int maxCount = 0;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == 1) {
                count++; // increase current streak
                if (count > maxCount) {
                    maxCount = count; // update max streak
                }
            } else {
                count = 0; // reset on 0
            }
        }

        System.out.println("Maximum Consecutive Ones: " + maxCount);
    }
}