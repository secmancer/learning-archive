import java.util.Scanner;

public class TriangleArea
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter base and height separated by a space");
        double num1 = scanner.nextDouble(), num2 = scanner.nextDouble();
        double sum = (num1 * 0.5) * num2;
        System.out.println("Area: " + sum);
    }
}
