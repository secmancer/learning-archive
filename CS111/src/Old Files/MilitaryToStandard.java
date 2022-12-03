import java.util.Scanner;

public class MilitaryToStandard
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a time value in the following format: HH MM SS");
        int hour = scanner.nextInt();
        int minute = scanner.nextInt();
        int second = scanner.nextInt();

        String timeIndicator = "";
        String newHour = " ";
        boolean isValid = true;

        switch (hour) {
            case 0:
                newHour = "12";
                timeIndicator = "AM";
                break;
            case 1:
                newHour = "01";
                timeIndicator = "AM";
                break;
            case 2:
                newHour = "02";
                timeIndicator = "AM";
                break;
            case 3:
                newHour = "03";
                timeIndicator = "AM";
                break;
            case 4:
                newHour = "04";
                timeIndicator = "AM";
                break;
            case 5:
                newHour = "05";
                timeIndicator = "AM";
                break;
            case 6:
                newHour = "06";
                timeIndicator = "AM";
                break;
            case 7:
                newHour = "07";
                timeIndicator = "AM";
                break;
            case 8:
                newHour = "08";
                timeIndicator = "AM";
                break;
            case 9:
                newHour = "09";
                timeIndicator = "AM";
                break;
            case 10:
                newHour = "10";
                timeIndicator = "AM";
                break;
            case 11:
                newHour = "11";
                timeIndicator = "AM";
                break;
            case 12:
                newHour = "12";
                timeIndicator = "PM";
                break;
            case 13:
                newHour = "01";
                timeIndicator = "PM";
                break;
            case 14:
                newHour = "02";
                timeIndicator = "PM";
                break;
            case 15:
                newHour = "03";
                timeIndicator = "PM";
                break;
            case 16:
                newHour = "04";
                timeIndicator = "PM";
                break;
            case 17:
                newHour = "05";
                timeIndicator = "PM";
                break;
            case 18:
                newHour = "06";
                timeIndicator = "PM";
                break;
            case 19:
                newHour = "07";
                timeIndicator = "PM";
                break;
            case 20:
                newHour = "08";
                timeIndicator = "PM";
                break;
            case 21:
                newHour = "09";
                timeIndicator = "PM";
                break;
            case 22:
                newHour = "10";
                timeIndicator = "PM";
                break;
            case 23:
                newHour = "11";
                timeIndicator = "PM";
                break;
            default:
                isValid = false;
        }

        if (!isValid) {
            System.out.print("Hour must be between 0 and 23 inclusive.");
        } else if (minute < 10 && second < 10) {
            String newSec = "0" + second;
            String newMin = "0" + minute;
            System.out.println(newHour + ":" + newMin + ":" + newSec + timeIndicator);
        } else if (minute >= 10 && second < 10) {
            String newSec = "0" + second;
            System.out.println(newHour + ":" + minute + ":" + newSec + timeIndicator);
        } else if (minute < 10 && second >= 10) {
            String newMin = "0" + minute;
            System.out.println(newHour + ":" + newMin + ":" + second + timeIndicator);
        } else {
            System.out.println(newHour + ":" + minute + ":" + second + timeIndicator);
        }
    }
}
