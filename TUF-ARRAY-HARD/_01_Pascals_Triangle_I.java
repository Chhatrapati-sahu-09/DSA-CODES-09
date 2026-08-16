public class _01_Pascals_Triangle_I {

    public static int[][] generate(int numRows) {

        int[][] triangle = new int[numRows][];

        for (int i = 0; i < numRows; i++) {

            triangle[i] = new int[i + 1];

            for (int j = 0; j <= i; j++) {

                if (j == 0 || j == i) {
                    triangle[i][j] = 1;
                } else {
                    triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
                }
            }
        }

        return triangle;
    }

    public static int[] getRow(int rowIndex) {

        int[] row = new int[rowIndex + 1];

        row[0] = 1;

        long ans = 1;

        for (int i = 1; i <= rowIndex; i++) {

            ans = ans * (rowIndex - i + 1) / i;
            row[i] = (int) ans;
        }

        return row;
    }

    public static int getElement(int row, int col) {

        if (col == 0 || col == row)
            return 1;

        long ans = 1;

        for (int i = 1; i <= col; i++) {
            ans = ans * (row - i + 1) / i;
        }

        return (int) ans;
    }

    public static void printTriangle(int[][] triangle) {

        for (int i = 0; i < triangle.length; i++) {

            for (int j = 0; j < triangle[i].length; j++) {
                System.out.print(triangle[i][j] + " ");
            }

            System.out.println();
        }
    }

    public static void printRow(int[] row) {

        for (int num : row) {
            System.out.print(num + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {

        System.out.println("Pascal Triangle (5 Rows)");
        int[][] triangle = generate(5);
        printTriangle(triangle);

        System.out.println();

        System.out.println("Entire 4th Row");
        printRow(getRow(4));

        System.out.println();

        System.out.println("Element at Row = 4, Column = 2");
        System.out.println(getElement(4, 2));
    }
}