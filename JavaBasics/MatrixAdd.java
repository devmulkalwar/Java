import java.util.Scanner;

public class MatrixAdd {

    public static void matrixInput(int[][] matrix, Scanner scanner) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
    }

    public static void showResultMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j <  matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int rows = scanner.nextInt();

        System.out.print("Enter number of cols: ");
        int cols = scanner.nextInt();

        if (rows <= 0 || cols <= 0) {
            System.out.println("Invalid matrix dimensions.");
            return;
        }

        int[][] matrixA = new int[rows][cols];
        int[][] matrixB = new int[rows][cols];
        int[][] resultMatrix = new int[rows][cols];

        System.out.println("Enter elements of matrix A:");
        matrixInput(matrixA, scanner);

        System.out.println("Enter elements of matrix B:");
        matrixInput(matrixB, scanner);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                resultMatrix[i][j] = matrixA[i][j] + matrixB[i][j];
            }
        }

        System.out.println("Resultant Matrix (A + B):");
        showResultMatrix(resultMatrix);

        scanner.close();
    }
}
