
import java.util.*;

public class _11_Set_Matrix_Zeroes {

    public static void setZeroes(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        boolean firstRowZero = false;
        boolean firstColZero = false;

        for (int j = 0; j < cols; j++) {
            if (matrix[0][j] == 0) {
                firstRowZero = true;
                break;
            }
        }

        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) {
                firstColZero = true;
                break;
            }
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (firstRowZero) {
            Arrays.fill(matrix[0], 0);
        }

        if (firstColZero) {
            for (int i = 0; i < rows; i++) {
                matrix[i][0] = 0;
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
                { 1, 1, 1 },
                { 1, 0, 1 },
                { 1, 1, 1 }
        };

        System.out.println("Test Case 1:");
        System.out.println("Input:");
        printMatrix(matrix1);
        setZeroes(matrix1);
        System.out.println("Output:");
        printMatrix(matrix1);
        System.out.println();

        // Test Case 2
        int[][] matrix2 = {
                { 1, 2, 3, 4 },
                { 5, 0, 7, 8 },
                { 9, 10, 11, 12 }
        };

        System.out.println("Test Case 2:");
        System.out.println("Input:");
        printMatrix(matrix2);
        setZeroes(matrix2);
        System.out.println("Output:");
        printMatrix(matrix2);
        System.out.println();

        // Test Case 3
        int[][] matrix3 = {
                { 0, 1, 2, 0 },
                { 3, 4, 5, 2 },
                { 1, 3, 1, 5 }
        };

        System.out.println("Test Case 3:");
        System.out.println("Input:");
        printMatrix(matrix3);
        setZeroes(matrix3);
        System.out.println("Output:");
        printMatrix(matrix3);
        System.out.println();

        // Test Case 4
        int[][] matrix4 = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 0 }
        };

        System.out.println("Test Case 4:");
        System.out.println("Input:");
        printMatrix(matrix4);
        setZeroes(matrix4);
        System.out.println("Output:");
        printMatrix(matrix4);
        System.out.println();

        // Test Case 5
        int[][] matrix5 = {
                { 0, 0 },
                { 0, 0 }
        };

        System.out.println("Test Case 5:");
        System.out.println("Input:");
        printMatrix(matrix5);
        setZeroes(matrix5);
        System.out.println("Output:");
        printMatrix(matrix5);
        System.out.println();

        // Test Case 6
        int[][] matrix6 = {
                { 5 }
        };

        System.out.println("Test Case 6:");
        System.out.println("Input:");
        printMatrix(matrix6);
        setZeroes(matrix6);
        System.out.println("Output:");
        printMatrix(matrix6);
        System.out.println();
    }
}
