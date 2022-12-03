import java.util.Scanner;

public class NumberAddPattern
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first number");
        int firstNum = scanner.nextInt();
        System.out.println("Enter second number");
        int secondNum = scanner.nextInt();
        int secondNumCopy = secondNum;

        int sum = firstNum + secondNum;

        System.out.println(firstNum + " + " + secondNum + " = " + sum);
        secondNum = secondNum + secondNumCopy;
        sum = firstNum + secondNum;
        System.out.println(firstNum + " + " + secondNum + " = " + sum);
        secondNum = secondNum + secondNumCopy;
        sum = firstNum + secondNum;
        System.out.println(firstNum + " + " + secondNum + " = " + sum);
        secondNum = secondNum + secondNumCopy;
        sum = firstNum + secondNum;
        System.out.println(firstNum + " + " + secondNum + " = " + sum);
        secondNum = secondNum + secondNumCopy;
        sum = firstNum + secondNum;
        System.out.println(firstNum + " + " + secondNum + " = " + sum);
    }
}
