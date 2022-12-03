import java.util.Scanner;

public class TestScoreList
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter name");
        String name = scanner.nextLine();
        TestScores testScores = new TestScores(name);

        int scoreNum = 1;

        while (true)
        {
            System.out.println("Enter score " + scoreNum + " or a negative number to exit");
            double num = scanner.nextDouble();
            if (num < 0)
            {
                break;
            }
            testScores.addTestScore(num);
            scoreNum++;
        }
        System.out.println("-- " + name + " --");
        System.out.println("Num tests taken: " + testScores.getNumTestsTaken());
        System.out.printf("Average: %.1f\n", testScores.getAverage());
    }
}
