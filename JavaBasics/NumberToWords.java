import java.sql.SQLOutput;
import java.util.Scanner;

public class NumberToWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int num = scanner.nextInt();

        String[] singleDigitNums = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
        String[] specialNums = {"Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] doubleDigitNums = {"Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        String[] multiDigitNums = {"Hundred", "Thousand", "Million", "Billion", "Trillion", "Quadrillion"};

        String numStr = Integer.toString(num);
        int digitCount = numStr.length();

        String numInWords = "";

        if (num >= 0 && num < 10) {
            for (int i = 0; i < 10; i++) {
                if (num == i) {
                    numInWords = singleDigitNums[i];
                }
            }
        } else if (num > 10 && num < 20) {

            int idx = num % 10;

            numInWords = specialNums[idx - 1];
        } else if (num >= 10 && num < 100) {
            int tens = num / 10;
            int ones = num % 10;
            numInWords = doubleDigitNums[tens - 1];
            if (ones != 0) {
                numInWords +=  " " + singleDigitNums[ones];
            }
        } else {
            numInWords = "aaloo";
        }


        System.out.println("Number in words : " + numInWords);
        scanner.close();
    }
}
