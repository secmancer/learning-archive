import java.util.Scanner;

public class Lottery
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int[] lotteryNumbers = new int[5];

        System.out.println("Check your lottery numbers here!");
        int indexCount = 0;
        int numCount = 1;
        while (indexCount != 5)
        {
            System.out.println("Enter number " + numCount + ":");
            int num = scanner.nextInt();
            if (num >= 1 && num <= 99)
            {
                lotteryNumbers[indexCount] = num;
                indexCount++;
                numCount++;
            }
            else
            {
                System.out.println("Must be between 1 and 99");
            }
        }

        System.out.println("All set. The winning numbers were: 8 13 27 53 54");
        int matchingNumbers = 0;

        boolean eightPresent = false;
        boolean thirteenPresent = false;
        boolean twentySevenPresent = false;
        boolean fiftyThreePresent = false;
        boolean fiftyFourPresent = false;

        for (int i = 0; i < 5; i++)
        {
            int currNum = lotteryNumbers[i];
            if (currNum == 8)
            {
                eightPresent = true;
                matchingNumbers++;
            }
            else if (currNum == 13)
            {
                thirteenPresent = true;
                matchingNumbers++;
            }
            else if (currNum == 27)
            {
                twentySevenPresent = true;
                matchingNumbers++;
            }
            else if (currNum == 53)
            {
                fiftyThreePresent = true;
                matchingNumbers++;
            }
            else if (currNum == 54)
            {
                fiftyFourPresent = true;
                matchingNumbers++;
            }
        }

        if (eightPresent && thirteenPresent && twentySevenPresent && fiftyThreePresent && fiftyFourPresent)
        {
            System.out.println("WOW! Grand prize winner!");
        }
        else
        {
            System.out.println("Well, you didn't win. You got " + matchingNumbers + " matching number(s)");
        }
    }
}
