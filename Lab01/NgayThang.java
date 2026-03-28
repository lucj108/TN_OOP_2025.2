import java.util.Scanner;

public class NgayThang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int month = 0;
        int year = 0;

        while (true) {
            System.out.print("Nhap thang: ");
            String inputMonth = sc.next();
            System.out.print("Nhap nam: ");
            if (sc.hasNextInt()) {
                year = sc.nextInt();
                if (year < 0) continue;
            } else {
                sc.next();
                continue;
            }

            if (inputMonth.equals("January") || inputMonth.equals("Jan.") || inputMonth.equals("Jan") || inputMonth.equals("1")) month = 1;
            else if (inputMonth.equals("February") || inputMonth.equals("Feb.") || inputMonth.equals("Feb") || inputMonth.equals("2")) month = 2;
            else if (inputMonth.equals("March") || inputMonth.equals("Mar.") || inputMonth.equals("Mar") || inputMonth.equals("3")) month = 3;
            else if (inputMonth.equals("April") || inputMonth.equals("Apr.") || inputMonth.equals("Apr") || inputMonth.equals("4")) month = 4;
            else if (inputMonth.equals("May") || inputMonth.equals("5")) month = 5;
            else if (inputMonth.equals("June") || inputMonth.equals("Jun") || inputMonth.equals("6")) month = 6;
            else if (inputMonth.equals("July") || inputMonth.equals("Jul") || inputMonth.equals("7")) month = 7;
            else if (inputMonth.equals("August") || inputMonth.equals("Aug.") || inputMonth.equals("Aug") || inputMonth.equals("8")) month = 8;
            else if (inputMonth.equals("September") || inputMonth.equals("Sept.") || inputMonth.equals("Sep") || inputMonth.equals("9")) month = 9;
            else if (inputMonth.equals("October") || inputMonth.equals("Oct.") || inputMonth.equals("Oct") || inputMonth.equals("10")) month = 10;
            else if (inputMonth.equals("November") || inputMonth.equals("Nov.") || inputMonth.equals("Nov") || inputMonth.equals("11")) month = 11;
            else if (inputMonth.equals("December") || inputMonth.equals("Dec.") || inputMonth.equals("Dec") || inputMonth.equals("12")) month = 12;

            if (month != 0) break;
        }

        int days = 0;
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            days = 31;
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            days = 30;
        } else if (month == 2) {
            if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                days = 29;
            } else {
                days = 28;
            }
        }
        System.out.println("So ngay: " + days);
    }
}