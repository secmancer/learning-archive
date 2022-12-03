import java.util.Scanner;

public class NumPattern
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first number");
        int num1 = scanner.nextInt();
        System.out.println("Enter second number");
        int num2 = scanner.nextInt();
        for (int i = 0; i < 5; i++) {
            System.out.println(num1 + " + " + num2 + " = " + (num1 + num2));
        }
    }
}
