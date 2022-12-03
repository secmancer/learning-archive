import java.util.Scanner;

public class IntegerReader
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many integers do you have? (Max 20)");
        int arraySize = scanner.nextInt();
        if (arraySize <= 20 && arraySize >= 1) {
            int[] numArray = new int[arraySize];
            for (int i = 0; i < arraySize; i++)
            {
                System.out.println("Enter element for subscript " + i);
                numArray[i] = scanner.nextInt();
            }
            System.out.println("Here are all of those numbers");
            int sum = 0;
            for (int i = 0; i < arraySize; i++)
            {
                System.out.println(numArray[i]);
                sum += numArray[i];
            }
            System.out.println("The sum of these numbers is " + sum);
        }
        else
        {
            System.out.println("You must enter a number in between 1 and 20");
        }
    }
}
