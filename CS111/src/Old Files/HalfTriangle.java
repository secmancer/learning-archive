import java.util.Scanner;

public class HalfTriangle
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a height");
        int height = scanner.nextInt();
        if (height <= 0) {
            System.out.println("Height must be at least one.");
        }
        else
        {
            for (int i = 1; i <= height; i++)
            {
                for (int j = 1; j <= i; j++)
                {
                    System.out.print('*');
                }
                System.out.print("\n");
            }
        }
    }
}
