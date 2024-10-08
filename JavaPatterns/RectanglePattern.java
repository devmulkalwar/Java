import java.util.Scanner;

public class RectanglePattern {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of rows : ");
        int rows = scanner.nextInt();

        System.out.print("Enter number of columns : ");
        int cols = scanner.nextInt();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                System.out.print("* ");

            }
            System.out.println();
        }

    }
}
