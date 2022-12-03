import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TwoCharFilter
{
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("db.txt");
        Scanner scanner = new Scanner(System.in);
        char letter1 = ' ', letter2 = ' ';
        int matchesCount = 0;

        System.out.println("Movie search by characters. Enter two characters.");
        String letters = scanner.nextLine();
        letter1 = letters.charAt(0);
        letter2 = letters.charAt(1);

        System.out.println("Movies that start with " + letters);

        Scanner fileInput = new Scanner(file);
        while (fileInput.hasNext())
        {
            String currLine = fileInput.nextLine();
            if (currLine.charAt(0) == letter1 && currLine.charAt(1) == letter2)
            {
                matchesCount++;
            }
        }
        fileInput.close();

        System.out.println("Number of matches: " + matchesCount);
    }
}
