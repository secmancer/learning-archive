import java.util.Scanner;

public class EnterInteger {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an integer");
        int num = scanner.nextInt();
        int sum = num + 1;
        System.out.println(num + " + 1 = " + sum);
    }
}
