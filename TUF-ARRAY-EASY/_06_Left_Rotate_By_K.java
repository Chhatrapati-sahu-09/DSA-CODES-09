class _06_Left_Rotate_By_K {

    // Reverse function
    void reverseArray(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    // Rotate function
    public int[] rotateArray(int[] nums, int k, String direction) {
        int n = nums.length;

        if (n == 0 || k == 0)
            return nums;

        k = k % n;

        if ("right".equals(direction)) {
            reverseArray(nums, 0, n - 1);
            reverseArray(nums, 0, k - 1);
            reverseArray(nums, k, n - 1);
        } else if ("left".equals(direction)) {
            reverseArray(nums, 0, k - 1);
            reverseArray(nums, k, n - 1);
            reverseArray(nums, 0, n - 1);
        }

        return nums;
    }

    public static void main(String[] args) {

        _06_Left_Rotate_By_K sol = new _06_Left_Rotate_By_K();

        int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
        int k = 2;
        String direction = "right";

        int[] result = sol.rotateArray(nums, k, direction);

        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}