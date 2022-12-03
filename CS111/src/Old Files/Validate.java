import java.util.Scanner;

public class Validate
{
    public static String getName(Scanner keyboard)
    {
        boolean isValid = false;
        System.out.println("Enter a name. The name must be in between 5 and 15 characters.");
        String name = keyboard.nextLine();
        while (!isValid)
        {
            if (name.length() >= 5 && name.length() <= 15)
            {
                isValid = true;
            }
            else
            {
                System.out.println("Enter a name. The name must be in between 5 and 15 characters.");
                name = keyboard.nextLine();
            }
        }
        return name;
    }
}
