import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReaderMain
{
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a filename");
        String fileName = scanner.nextLine();
        FileStats fileStats = new FileStats(fileName);
        System.out.println(fileName + " has " + fileStats.getNumLines() + " lines");
        System.out.println("Enter some text");
        String filterText = scanner.nextLine();
        System.out.println(fileStats.getNumLinesThatContain(filterText) + " line(s) contain \"" + filterText + "\"");
    }
}
