import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first number : ");
        int number1 = scanner.nextInt();
        System.out.print("Enter second number : ");
        int number2 = scanner.nextInt();
        System.out.print("Enter an operator (+, -, *, /) : ");
        char operator = scanner.next().charAt(0);
        
        int result = 0; 
        
        switch (operator) { 
            case '+':
                result = number1 + number2;
                break;
            case '-':
                result = number1 - number2;
                break;
            case '*':
                result = number1 * number2;
                break;
            case '/':
                if (number2!= 0) {
                    result = number1 / number2;
                } else {
                    System.out.println("Error! Division by zero is not allowed.");
                }
                break;
            default:
                System.out.println("Error! Invalid operator. Please use one of the following: +, -, *, /");
        }
        System.out.println("The result is : " + result);
        scanner.close();
    }
}
