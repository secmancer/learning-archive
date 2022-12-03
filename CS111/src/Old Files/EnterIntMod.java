import java.util.Scanner;

public class EnterIntMod
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an integer");
        int number = scanner.nextInt();
        int result = number % 2;
        System.out.print(number + " mod 2 = " + result);
    }
}
