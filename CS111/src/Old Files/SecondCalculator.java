import java.util.Scanner;

public class SecondCalculator
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of seconds");
        int seconds = scanner.nextInt();
        int totalSeconds = seconds;
        int days = 0;
        int hours = 0;
        int minutes = 0;

        if (totalSeconds / 86400 >= 1) {
            days = (totalSeconds / 86400);
            totalSeconds = totalSeconds - (86400 * days);
            System.out.println(days + " day(s)");
        }

        if (totalSeconds / 3600 >= 1) {
            hours = (totalSeconds / 3600);
            totalSeconds = totalSeconds - (3600 * hours);
            System.out.println(hours + " hour(s)");
        }

        if (totalSeconds / 60 >= 1) {
            minutes = (totalSeconds / 60);
            totalSeconds = totalSeconds - (60 * minutes);
            System.out.println(minutes + " minute(s)");
        }

        if (totalSeconds > 0) {
            System.out.println(totalSeconds + " second(s)");
        }
     }
}
