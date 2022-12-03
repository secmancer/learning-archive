import java.util.Scanner;

public class Rectangle
{
    public static double getLength(Scanner keyboard)
    {
        System.out.println("Enter length: ");
        return keyboard.nextDouble();
    }

    public static double getWidth(Scanner keyboard)
    {
        System.out.println("Enter width: ");
        return keyboard.nextDouble();
    }

    public static double getArea(double length, double width)
    {
        return length * width;
    }

    public static void displayData(double length, double width)
    {
        System.out.println("-- Rectangle info --");
        System.out.printf("Length: %.1f\n", length);
        System.out.printf("Width: %.1f\n", width);
        System.out.printf("Area: %.1f\n", getArea(length, width));
    }
}
