import java.util.*;
public class PalindromeString {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a word:");
        String str = sc.next().toLowerCase();
        String reverseStr = "";

        for (int i = str.length() - 1; i >= 0; i--) {
            reverseStr += str.charAt(i);
        }

        if (str.equalsIgnoreCase(reverseStr)) {
            System.out.println(str + " is a palindrome.");
        } else {
            System.out.println(str + " is not a palindrome.");
        }

        sc.close();
    }
}