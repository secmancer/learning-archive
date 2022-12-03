import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SimilarMovies
{
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("db.txt");
        List<String> filmList = new ArrayList<>();

        int currentIndex = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Similar title finder. Enter a movie name.");

        String title = scanner.nextLine();

        System.out.println("Here are the 3 movies that are listed before the one you entered");

        Scanner fileInput = new Scanner(file);
        while (fileInput.hasNext())
        {
            currentIndex++;
            String filmName = fileInput.nextLine();
            filmList.add(filmName);
            fileInput.nextLine();
            fileInput.nextLine();
            if (filmName.equals(title))
            {
                System.out.println(filmList.get(currentIndex - 4));
                System.out.println(filmList.get(currentIndex - 3));
                System.out.println(filmList.get(currentIndex - 2));
                break;
            }
        }
    }
}
