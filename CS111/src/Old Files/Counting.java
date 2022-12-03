import java.util.Scanner;

public class Counting
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an ending value");
        int endingNum = scanner.nextInt();
        scanner.nextLine();
        String countIndicator = "";

        while (countIndicator.compareTo("up") != 0 && countIndicator.compareTo("down") != 0)
        {
            System.out.println("Count up or down?");
            String rawIndicator = scanner.nextLine();
            countIndicator = rawIndicator.toLowerCase();
        }

        if (countIndicator.compareTo("up") == 0)
        {
            for (int i = 1; i <= endingNum; i++)
            {
                if (i >= 1 && i <= 9)
                {
                    System.out.print("    " + i);
                }
                else if (i >= 10)
                {
                    System.out.print("   " + i);
                }

                int plusTen = i + 10;
                int plusHundred = i + 100;

                System.out.print("   " + plusTen);
                System.out.print("  " + plusHundred);
                System.out.print("\n");
            }
        }
        else if (countIndicator.compareTo("down") == 0)
        {
            for (int i = 1; i <= endingNum; i++)
            {
                int invertI = i * -1;
                if (invertI >= -9 && invertI <= -1)
                {
                    System.out.print("   " + invertI);
                }
                else if (invertI <= -10 && invertI >= -99)
                {
                    System.out.print("  " + invertI);
                }
                else if (invertI <= -100)
                {
                    System.out.print(" " + invertI);
                }

                int plusTen = invertI + 10;

                if (plusTen >= 0)
                {
                    System.out.print("    " + plusTen);
                }
                else if (plusTen >= -9 && plusTen <= -1)
                {
                    System.out.print("   " + plusTen);
                }
                else if (plusTen <= -10 && plusTen >= -99)
                {
                    System.out.print("  " + plusTen);
                }
                else if (plusTen <= -100)
                {
                    System.out.print(" " + plusTen);
                }

                int plusHundred = invertI + 100;

                if (plusHundred >= 10)
                {
                    System.out.print("   " + plusHundred);
                }
                else if (plusHundred >= 0 && plusHundred <= 9)
                {
                    System.out.print("    " + plusHundred);
                }
                else if (plusHundred >= -9 && plusHundred <= -1)
                {
                    System.out.print("   " + plusHundred);
                }
                else if (plusHundred <= -10 && plusHundred >= -99)
                {
                    System.out.print("  " + plusHundred);
                }
                else if (plusHundred <= -100)
                {
                    System.out.print(" " + plusHundred);
                }

                System.out.print("\n");
            }
        }
    }
}