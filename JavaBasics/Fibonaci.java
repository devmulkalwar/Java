import java.util.Scanner;

public class Fibonaci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of terms: ");
        int n = scanner.nextInt();
        
        int a = 0, b = 1;
        
        System.out.println("Fibonacci sequence:");
        
        for (int i = 0; i < n; i++) {
            System.out.print(a + " "); 
            int sum = a + b;
            a = b;
            b = sum;
        }

        scanner.close();
    }
}
