
import java.util.*;

public class _12_Rotate_Matrix_By_90_Degrees {

    public static void rotate(int[][] matrix) {

        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = n - 1;

            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;

                left++;
                right--;
            }
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
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
        printMatrix(matrix1);
        rotate(matrix1);
        System.out.println("Output:");
        printMatrix(matrix1);
        System.out.println();

        // Test Case 2
        int[][] matrix2 = {
                { 1, 2 },
                { 3, 4 }
        };

        System.out.println("Test Case 2:");
        System.out.println("Input:");
        printMatrix(matrix2);
        rotate(matrix2);
        System.out.println("Output:");
        printMatrix(matrix2);
        System.out.println();

        // Test Case 3
        int[][] matrix3 = {
                { 1 }
        };

        System.out.println("Test Case 3:");
        System.out.println("Input:");
        printMatrix(matrix3);
        rotate(matrix3);
        System.out.println("Output:");
        printMatrix(matrix3);
        System.out.println();

        // Test Case 4
        int[][] matrix4 = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 }
        };

        System.out.println("Test Case 4:");
        System.out.println("Input:");
        printMatrix(matrix4);
        rotate(matrix4);
        System.out.println("Output:");
        printMatrix(matrix4);
        System.out.println();

        // Test Case 5
        int[][] matrix5 = {
                { -1, -2 },
                { -3, -4 }
        };

        System.out.println("Test Case 5:");
        System.out.println("Input:");
        printMatrix(matrix5);
        rotate(matrix5);
        System.out.println("Output:");
        printMatrix(matrix5);
        System.out.println();

        // Test Case 6
        int[][] matrix6 = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };

        System.out.println("Test Case 6:");
        System.out.println("Input:");
        printMatrix(matrix6);
        rotate(matrix6);
        System.out.println("Output:");
        printMatrix(matrix6);
        System.out.println();
    }
}
