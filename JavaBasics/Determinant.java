import java.util.Scanner;

public class Determinant {

    public static void matrixInput(int[][] matrix, Scanner scanner) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print("Enter element [" + i + "][" + j + "]: ");
                matrix[i][j] = scanner.nextInt();
            }
        }
    }

    public static void displayMatrix(int[][] matrix) {
        System.out.println("Matrix:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }


    public static int calculateDeterminant(int[][] matrix, int n) {
        int determinant = 0;

        // Base case for a 1x1 matrix
        if (n == 1) {
            return matrix[0][0];
        }

        if (n == 2) {
            return (matrix[0][0] * matrix[1][1]) - (matrix[0][1] * matrix[1][0]);
        }

        int[][] subMatrix = new int[n - 1][n - 1];

        for (int x = 0; x < n; x++) {
            int subRow = 0;
            for (int i = 1; i < n; i++) {
                int subCol = 0;
                for (int j = 0; j < n; j++) {
                    if (j == x) {
                        continue;
                    }
                    subMatrix[subRow][subCol] = matrix[i][j];
                    subCol++;
                }
                subRow++;
            }

            int sign = (x % 2 == 0) ? 1 : -1;
            determinant += sign * matrix[0][x] * calculateDeterminant(subMatrix, n - 1);
        }
        return determinant;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the square matrix: ");
        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("Matrix size should be greater than 0.");
            scanner.close();
            return;
        }

        int[][] matrix = new int[n][n];

        System.out.println("Enter elements of the matrix:");
        matrixInput(matrix, scanner);

        displayMatrix(matrix);

        int determinant = calculateDeterminant(matrix, n);
        System.out.println("The determinant of the matrix is: " + determinant);

        scanner.close();
    }
}
