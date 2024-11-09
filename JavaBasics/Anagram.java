import java.util.Arrays;
import java.util.Scanner;

public class Anagram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first string :");
        String str1 = scanner.next().toLowerCase();;

        System.out.println("Enter second string :");
        String str2 = scanner.next().toLowerCase();

        if(str1.length() == str2.length()){
            String result1 = sortAlphabetically( str1);
            String result2 = sortAlphabetically( str2);
            if (result1.equals(result2)){
                System.out.println("Strings are anagram");
            }
            else {
                System.out.println("Strings are not anagram");
            }
        }
        else {
            System.out.println("Strings are not anagram");
        }
        scanner.close();
    }

    public static String sortAlphabetically(String str) {

        char[] charArray = str.toCharArray();

        Arrays.sort(charArray);

        return new String(charArray);
    }
}
