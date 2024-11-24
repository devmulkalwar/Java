import java.util.Scanner;

public class DateToDay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter day: ");
        int day = scanner.nextInt();

        System.out.print("Enter month: ");
        int month = scanner.nextInt();

        System.out.print("Enter year: ");
        int year = scanner.nextInt();

        if (!isValidDate(day, month, year)) {
            System.out.println("Please enter a valid date...");
            scanner.close();
            return;
        }

        // Array for day names
        String[] dayCode = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

        // Month codes
        int[] monthCodes = {0, 3, 3, 6, 1, 4, 6, 2, 5, 0, 3, 5};
        int monthCode = monthCodes[month - 1];

        // Century codes repeat every 400 years
        int[] centuryCodes = {6, 4, 2, 0};
        int century = year / 100;
        int centuryCode = centuryCodes[(century % 4)];

        // Calculations
        int yearPart = year % 100;
        int yearPartQuotient = yearPart / 4;

        int answer = day + monthCode + centuryCode + yearPart + yearPartQuotient;

        // Leap year adjustment for January and February
        if (isLeapYear(year) && (month == 1 || month == 2)) {
            answer -= 1;
        }

        // Get the day index (0-6)
        answer = answer % 7;

        System.out.println("The day on date " + day + "/" + month + "/" + year + " is " + dayCode[answer]);
        scanner.close();
    }

    // Helper method to check for leap year
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0) && ((year % 100 != 0) || (year % 400 == 0));
    }

    // Helper method to validate the date
    public static boolean isValidDate(int day, int month, int year) {
        if (year < 1 || month < 1 || month > 12 || day < 1) {
            return false;
        }

        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        // Adjust February for leap year
        if (isLeapYear(year)) {
            daysInMonth[1] = 29;
        }

        return day <= daysInMonth[month - 1];
    }
}
