import java.util.Scanner;

public class Gcd {
    public static void main(String[] args) {
       int gcd = 0  ;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter 1st number: ");
        int a = scanner.nextInt();
        System.out.print("Enter 2nd number: ");
        int b = scanner.nextInt();

        if(a==0 || b==0){
            System.out.println("Numbers cannot be 0 ");
            return;
        }
        int max = Math.max(a,b);
        int min = Math.min(a,b);

        if(max%min == 0){
            gcd =min ;
            System.out.println("The GCD of " + a + " and " + b +" is: "+ gcd);
        }
        else{
            for (int i = 1; i < max; i++) {
                if(max%i == 0){
                    if(min%i==0){
                        gcd = i;
                    }
                }
            }
            System.out.println("The GCD of " + a + " and " + b +" is: "+ gcd);
        }


        scanner.close();
    }
}
