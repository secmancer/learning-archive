import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MovieFilter
{
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("db.txt");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Movie search by characters. Enter two characters.");

        String letters = scanner.nextLine();
        int countSum = 0;

        System.out.println("Movies that start with " + letters);
        Scanner fileInput = new Scanner(file);
        while (fileInput.hasNext())
        {
            String currentLine = fileInput.nextLine();
            int firstCharIndex = currentLine.indexOf(letters.charAt(0));
            int secondCharIndex = currentLine.indexOf(letters.charAt(1));
            if (firstCharIndex == 0 && secondCharIndex == 1)
            {
                System.out.println(currentLine);
                countSum++;
            }
        }
        if (countSum == 0)
        {
            System.out.println("No matching movies found!");
        }
        else
        {
            System.out.println("Number of matches: " + countSum);
        }
    }
}
