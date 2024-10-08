import java.util.Scanner;

public class ChristmusTree {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of rows  : ");
        int rows = scanner.nextInt();

        // Loop to print the upper part of the Christmas tree
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rows - i - 1; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        for (int i = rows / 2; i < rows; i++) {
            for (int j = 0; j < rows - i - 1; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }


        for (int i = 0; i < rows / 2; i++) {
            for (int j = 0; j < rows - 1; j++) {
                System.out.print(" ");
            }
            System.out.println("*");
        }

        scanner.close();
    }
}


