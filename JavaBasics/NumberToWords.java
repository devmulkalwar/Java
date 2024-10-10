import java.util.Scanner;

public class NumberToWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = scanner.nextInt();

        String[] singleDigitNums = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
        String[] specialNums = {"Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] doubleDigitNums = {"Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

        String numInWords = "";

        if (num >= 0 && num < 10) {
            numInWords = singleDigitNums[num];
        } else if (num > 10 && num < 20) {
            numInWords = specialNums[num - 11];
        } else if (num >= 10 && num < 100) {
            int tens = num / 10;
            int ones = num % 10;
            numInWords = doubleDigitNums[tens - 1];
            if (ones != 0) {
                numInWords += " " + singleDigitNums[ones];
            }
        } else if (num >= 100 && num < 1000) {
            int hundreds = num / 100;
            int remainder = num % 100;

            numInWords = singleDigitNums[hundreds] + " Hundred";

            if (remainder != 0) {
                if (remainder < 10) {
                    numInWords += " and " + singleDigitNums[remainder];
                } else if (remainder > 10 && remainder < 20) {
                    numInWords += " and " + specialNums[remainder - 11];
                } else {
                    int tens = remainder / 10;
                    int ones = remainder % 10;
                    numInWords += " and " + doubleDigitNums[tens - 1];
                    if (ones != 0) {
                        numInWords += " " + singleDigitNums[ones];
                    }
                }
            }
        } else {
            numInWords = "Number out of range!";
        }

        System.out.println("Number in words: " + numInWords);
        scanner.close();
    }
}
