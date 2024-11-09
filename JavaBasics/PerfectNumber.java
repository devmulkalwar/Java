import java.util.Scanner;

public class PerfectNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number : ");
        int num = scanner.nextInt();
        int sum = 0;
        for (int i = 1; i < num; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }
        if (sum == num) {
            System.out.println("Number is perfect number ");

        } else {
            System.out.println("Number is not a perfect number ");

        }
        scanner.close();
    }
}
