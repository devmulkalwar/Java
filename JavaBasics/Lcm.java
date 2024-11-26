import java.util.Scanner;

public class Lcm {
    // Function to calculate the GCD of two numbers
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Function to calculate the LCM of two numbers
    public static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of numbers: ");
        int num = scanner.nextInt();

        // Initialize an array to store the numbers
        int[] numbers = new int[num];

        // Input the numbers
        for (int i = 0; i < num; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }

        // Calculate the LCM of the array
        int result = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            result = lcm(result, numbers[i]);
        }

        System.out.println("The LCM of the entered numbers is: " + result);

        scanner.close();
    }
}
