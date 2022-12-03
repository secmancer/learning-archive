import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class YearFilter
{
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("db.txt");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Movie search by year range. Enter two years.");

        int firstYear = scanner.nextInt();
        int lastYear = scanner.nextInt();

        int countSum = 0;

        System.out.println("Movies with short names that were released between " + firstYear + " and " + lastYear);

        Scanner fileInput = new Scanner(file);
        while (fileInput.hasNext())
        {
            String filmName = fileInput.nextLine();
            String year = fileInput.nextLine();
            String category = fileInput.nextLine();
            if (Integer.valueOf(year) >= firstYear && Integer.valueOf(year) <= lastYear && filmName.length() < 6)
            {
                countSum++;
                System.out.println(filmName);
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
