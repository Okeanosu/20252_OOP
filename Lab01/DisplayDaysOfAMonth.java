public class DisplayDaysOfAMonth {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        int month, year;
        while (true) {
            System.out.print("Enter month (1-12): ");
            month = scanner.nextInt();
            System.out.print("Enter year: ");
            year = scanner.nextInt();
            if (month < 1 || month > 12 || year < 1) {
                System.out.println("Invalid month or year. Please try again.");
            } else {
                break;
            }
        }
        int daysInMonth;
        switch (month) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                daysInMonth = 31;
                break;
            case 4: case 6: case 9: case 11:
                daysInMonth = 30;
                break;
            case 2:
                if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                    daysInMonth = 29; 
                } else {
                    daysInMonth = 28;
                }
                break;
            default:
                daysInMonth = -1;
        }
        System.out.println("Number of days in that month is: " + daysInMonth);
        scanner.close();
    }
}
