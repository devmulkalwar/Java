import java.util.Scanner;

public class CelsiusToFahrenheit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for Celsius input
        System.out.print("Enter your choice (1. Celsius to Fahrenheit , 2. Fahrenheit to Celsius): ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                celsiusToFahrenheit();
                break;

            case 2:
                fahrenheitToCelsius();
                break;
            default:
                System.out.println("You have entered wrong choice");

        }

    }

    public static void celsiusToFahrenheit() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter temperature in Celsius: ");
        double celsius = scanner.nextDouble();

        double fahrenheit = (celsius * 9 / 5) + 32;
        System.out.println("Temperature in Fahrenheit: " + fahrenheit);


    }

    public static void fahrenheitToCelsius() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter temperature in Fahrenheit: ");
        double fahrenheit = scanner.nextDouble();

        double celsius = (fahrenheit - 32) * 5 / 9 ;
        System.out.println("Temperature in Fahrenheit: " + celsius);

        scanner.close();
    }
}
