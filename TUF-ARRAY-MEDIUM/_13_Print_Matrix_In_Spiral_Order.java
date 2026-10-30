
import java.util.*;

public class _13_Print_Matrix_In_Spiral_Order {

    public static List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> result = new ArrayList<>();

        int rows = matrix.length;
        int cols = matrix[0].length;

        int top = 0;
        int bottom = rows - 1;
        int left = 0;
        int right = cols - 1;

        while (top <= bottom && left <= right) {

            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        // Test Case 1
        int[][] matrix1 = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };

        System.out.println("Test Case 1:");
        System.out.println("Input:");
        for (int[] row : matrix1) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("Output : " + spiralOrder(matrix1));
        System.out.println();

        // Test Case 2
        int[][] matrix2 = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 }
        };

        System.out.println("Test Case 2:");
        System.out.println("Input:");
        for (int[] row : matrix2) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("Output : " + spiralOrder(matrix2));
        System.out.println();

        // Test Case 3
        int[][] matrix3 = {
                { 1, 2, 3, 4 }
        };

        System.out.println("Test Case 3:");
        System.out.println("Input:");
        for (int[] row : matrix3) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("Output : " + spiralOrder(matrix3));
        System.out.println();

        // Test Case 4
        int[][] matrix4 = {
                { 1 },
                { 2 },
                { 3 },
                { 4 }
        };

        System.out.println("Test Case 4:");
        System.out.println("Input:");
        for (int[] row : matrix4) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("Output : " + spiralOrder(matrix4));
        System.out.println();

        // Test Case 5
        int[][] matrix5 = {
                { 1, 2 },
                { 3, 4 }
        };

        System.out.println("Test Case 5:");
        System.out.println("Input:");
        for (int[] row : matrix5) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("Output : " + spiralOrder(matrix5));
        System.out.println();

        // Test Case 6
        int[][] matrix6 = {
                { 1, 2, 3, 4, 5 },
                { 6, 7, 8, 9, 10 }
        };

        System.out.println("Test Case 6:");
        System.out.println("Input:");
        for (int[] row : matrix6) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("Output : " + spiralOrder(matrix6));
        System.out.println();
    }
}
