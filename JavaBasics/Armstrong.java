import java.util.Scanner;

public class Armstrong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt(); // Input number
        int digits = String.valueOf(number).length();  // Count the number of digits
        int originalNumber = number;

        // Check if it's an Armstrong number
        boolean result = isArmstrong(number, digits, originalNumber);

        if (result) {
            System.out.println(originalNumber + " is an Armstrong number.");
        } else {
            System.out.println(originalNumber + " is not an Armstrong number.");
        }
        scanner.close(); // Close the scanner
    }

    // Method to check if a number is an Armstrong number
    public static boolean isArmstrong(int number, int digits, int originalNumber) {
        int sum = 0;

        // Calculate sum of digits raised to the power of the number of digits
        while (number > 0) {
            int digit = number % 10;
            sum += Math.pow(digit, digits);  // Raise each digit to the power of digits
            number /= 10; // Reduce the number by removing the last digit
        }

        // Return true if sum equals original number, else false
        return sum == originalNumber;
    }
}
