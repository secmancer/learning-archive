import java.util.Scanner;

public class EnterDouble
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an integer");
        double number = scanner.nextDouble();
        double sum = number + 1.0;
        System.out.println(number + " + 1.0 = " + sum);
    }
}
