import java.util.Scanner;

public class MatrixProduct {

    public static void matrixInput(int[][] matrix, Scanner scanner) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
    }

    public static void showResultMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter dimensions of matrix A : ");
        int rowA = scanner.nextInt();
        int colA = scanner.nextInt();

        System.out.println("Enter dimensions of matrix B : ");
        int rowB = scanner.nextInt();
        int colB = scanner.nextInt();

        if (rowA <= 0 || colA <= 0 || rowB <= 0 || colB <= 0) {
            System.out.println("Dimensions must be positive integers...");
            return;
        }

        if (colA != rowB) {
            System.out.println("Column of matrix A and row of matrix B must be the same...");
            return;
        }

        int[][] matrixA = new int[rowA][colA];
        int[][] matrixB = new int[rowB][colB];
        int[][] resultMatrix = new int[rowA][colB];

        System.out.println("Enter elements of matrix A:");
        matrixInput(matrixA, scanner);

        System.out.println("Enter elements of matrix B:");
        matrixInput(matrixB, scanner);

        for (int i = 0; i < rowA; i++) {
            for (int j = 0; j < colB; j++) {
                resultMatrix[i][j] = 0;
                for (int k = 0; k < colA; k++) {
                    resultMatrix[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }

        System.out.println("Resultant matrix after multiplication:");
        showResultMatrix(resultMatrix);

        scanner.close();
    }
}
