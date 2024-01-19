import com.sun.security.jgss.GSSUtil;

import java.time.Month;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter date(yyyy-dd-mm): ");
        String Shortdata = scanner.nextLine();
        int year = Integer.parseInt(Shortdata.substring(0,4));
        int month = Integer.parseInt(Shortdata.substring(5,7));
        int day = Integer.parseInt(Shortdata.substring(8,10));
        String getMonthName = getMonth(month);
        System.out.println("Output: " + day + " " + getMonthName + " " + year);
        scanner.close();

    }

    private static String getMonth(int month) {
        switch (month) {
            case 1:
                return "January";
            case 2:
                return "February";
            case 3:
                return "March";
            case 4:
                return "April";
            case 5:
                return "May";
            case 6:
                return "June";
            case 7:
                return "July";
            case 8:
                return "August";
            case 9:
                return "september";
            case 10:
                return "October";
            case 11:
                return "November";
            case 12:
                return "December";
            default:
                System.out.println("Invalid");
        }
        return null;
    }
}