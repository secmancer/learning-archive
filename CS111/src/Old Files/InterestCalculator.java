import java.util.Scanner;

public class InterestCalculator
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("== One Year Interest Calculator ==");
        System.out.println("How much money do you have?");
        double money = scanner.nextDouble();
        System.out.println("What's the interest rate?");
        double rawRate = scanner.nextDouble();
        double rate = rawRate / 100;
        double interest = rate * money * 1;
        System.out.println("Interest earned: $" + interest);
        double newBalance = money + interest;
        System.out.println("New balance: $" + newBalance);
    }
}
