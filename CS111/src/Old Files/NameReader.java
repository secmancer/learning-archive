import java.util.Scanner;

public class NameReader
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter five names");
        String[] namesArray = new String[5];
        for (int i = 0; i < 5; i++)
        {
            System.out.println("Enter friend " + (i + 1));
            namesArray[i] = scanner.nextLine();
        }
        System.out.println("Here are all of those names");
        for (int i = 0; i < 5; i++)
        {
            System.out.println("Friend " + (i + 1) + " is " + namesArray[i]);
        }
        System.out.println("Which friend is your best friend? (Enter an integer)");
        int selection = scanner.nextInt();
        String selectedName = namesArray[selection - 1];
        System.out.println(selectedName + "? Yes, " + selectedName + " is awesome");
    }
}
