import java.util.Scanner;

public class MatrixInverse {

    public static void matrixInput(int[][] matrix, Scanner scanner) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print("Enter element [" + i + "][" + j + "]: ");
                matrix[i][j] = scanner.nextInt();
            }
        }
    }

    public static void displayMatrix(String label, int[][] matrix) {
        System.out.println("======== " + label + " Matrix ========");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%6d", matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println("=================================\n");
    }

    public static void displayMatrix(String label, double[][] matrix) {
        System.out.println("======== " + label + " Matrix ========");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%8.2f", matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println("=================================\n");
    }

    public static int calculateDeterminant(int[][] matrix, int n) {
        if (n == 1) {
            return matrix[0][0];
        }

        if (n == 2) {
            return (matrix[0][0] * matrix[1][1]) - (matrix[0][1] * matrix[1][0]);
        }

        int determinant = 0;
        int[][] subMatrix = new int[n - 1][n - 1];

        for (int x = 0; x < n; x++) {
            int subRow = 0;
            for (int i = 1; i < n; i++) {
                int subCol = 0;
                for (int j = 0; j < n; j++) {
                    if (j == x) continue;
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

    public static int[][] getMinorMatrix(int[][] matrix, int n) {
        int[][] minorMatrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int[][] minor = getMinor(matrix, i, j, n);
                minorMatrix[i][j] = calculateDeterminant(minor, n - 1);
            }
        }
        return minorMatrix;
    }

    public static int[][] getMinor(int[][] matrix, int rowToExclude, int colToExclude, int n) {
        int[][] minor = new int[n - 1][n - 1];
        int minorRow = 0, minorCol;

        for (int i = 0; i < n; i++) {
            if (i == rowToExclude) continue;
            minorCol = 0;
            for (int j = 0; j < n; j++) {
                if (j == colToExclude) continue;
                minor[minorRow][minorCol] = matrix[i][j];
                minorCol++;
            }
            minorRow++;
        }
        return minor;
    }

    public static int[][] getCofactorMatrix(int[][] matrix, int n) {
        int[][] cofactorMatrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int[][] minor = getMinor(matrix, i, j, n);
                int determinant = calculateDeterminant(minor, n - 1);
                cofactorMatrix[i][j] = (int) Math.pow(-1, i + j) * determinant;
            }
        }
        return cofactorMatrix;
    }

    public static int[][] getAdjointMatrix(int[][] cofactorMatrix, int n) {
        int[][] adjointMatrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                adjointMatrix[j][i] = cofactorMatrix[i][j]; // Transpose of cofactor matrix
            }
        }
        return adjointMatrix;
    }

    public static double[][] calculateInverse(int[][] adjointMatrix, int determinant, int n) {
        double[][] inverseMatrix = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                inverseMatrix[i][j] = adjointMatrix[i][j] / (double) determinant;
            }
        }
        return inverseMatrix;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Program to find Minor, Cofactor, Adjoint, and Inverse Matrices.");
        System.out.print("Enter the size of the square matrix: ");
        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("Matrix size should be greater than 0...");
            scanner.close();
            return;
        }

        int[][] matrix = new int[n][n];
        System.out.println("Enter elements of the matrix:");
        matrixInput(matrix, scanner);

        displayMatrix("Input", matrix);

        int determinant = calculateDeterminant(matrix, n);
        System.out.println("Determinant: " + determinant + "\n");

        if (determinant == 0) {
            System.out.println("The matrix is not invertible as its determinant is zero.");
            scanner.close();
            return;
        }

        int[][] minorMatrix = getMinorMatrix(matrix, n);
        displayMatrix("Minor", minorMatrix);

        int[][] cofactorMatrix = getCofactorMatrix(matrix, n);
        displayMatrix("Cofactor", cofactorMatrix);

        int[][] adjointMatrix = getAdjointMatrix(cofactorMatrix, n);
        displayMatrix("Adjoint", adjointMatrix);

        double[][] inverseMatrix = calculateInverse(adjointMatrix, determinant, n);
        displayMatrix("Inverse", inverseMatrix);

        scanner.close();
    }
}
