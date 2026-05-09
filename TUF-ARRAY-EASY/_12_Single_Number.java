class _12_Single_Number {

    // Brute Force Approach
    public static int singleNumberBrute(int[] nums) {

        for (int i = 0; i < nums.length; i++) {

            int count = 0;

            for (int j = 0; j < nums.length; j++) {

                if (nums[i] == nums[j]) {
                    count++;
                }
            }

            if (count == 1) {
                return nums[i];
            }
        }

        return -1;
    }

    // Optimal XOR Approach
    public static int singleNumberOptimal(int[] nums) {

        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            result = result ^ nums[i];
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums = { 2, 5, 3, 5, 2 };

        System.out.println("Brute Force Answer: "
                + singleNumberBrute(nums));

        System.out.println("Optimal Answer: "
                + singleNumberOptimal(nums));
    }
}
