import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileStats
{
    private String filename;

    public FileStats(String filename)
    {
        this.filename = filename;
    }
    public int getNumLinesThatContain(String key) throws FileNotFoundException {
        String newKey = key.toLowerCase();
        int numLines = 0;
        File file = new File(filename);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNext())
        {
            String line = scanner.nextLine().toLowerCase();
            if (line.contains(newKey))
            {
                numLines++;
            }
        }
        return numLines;
    }

    public int getNumLines() throws FileNotFoundException {
        int numLines = 0;
        File file = new File(filename);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNext())
        {
            scanner.nextLine();
            numLines++;
        }
        return numLines;
    }
}
