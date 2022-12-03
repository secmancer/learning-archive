import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DictionaryCheck
{
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("dictionary.txt");

        Scanner scanner = new Scanner(System.in);
        String word = "";

        while (true)
        {
            Scanner fileInput = new Scanner(file);
            boolean isFound = false;
            System.out.println("Enter word to spellcheck (or exit to end)");
            word = scanner.nextLine();
            if (word.equalsIgnoreCase("exit"))
            {
                break;
            }
            while (fileInput.hasNext())
            {
                if (fileInput.nextLine().equals(word))
                {
                    isFound = true;
                    break;
                }
            }
            if (isFound)
            {
                System.out.println(word + " is spelled correctly.");
            }
            else
            {
                System.out.println(word + " is not spelled correctly.");
            }
        }
        System.out.println("Ending program...");
    }
}
