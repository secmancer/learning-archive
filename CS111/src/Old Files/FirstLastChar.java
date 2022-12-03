import java.util.Scanner;

public class FirstLastChar
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter some text");
        String text = scanner.nextLine();
        System.out.println("You entered: " + text);
        System.out.println("First letter: " + text.charAt(0));
        System.out.println("Last letter: " + text.charAt(text.length() - 1));
    }
}
