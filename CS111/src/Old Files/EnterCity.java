import java.util.Scanner;

public class EnterCity
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What's your favorite city?");
        String cityName = scanner.nextLine();
        System.out.println("Number of characters: " + cityName.length());
        System.out.println("First character: " + cityName.charAt(0));
        System.out.println("Uppercase: " + cityName.toUpperCase());
        System.out.println("Lowercase: " + cityName.toLowerCase());
    }
}
