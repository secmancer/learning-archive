public class TestScores
{
    private String name;
    private double totalScore;
    private int numScores;

    public TestScores(String name)
    {
        this.name = name;
        this.totalScore = 0.0;
        this.numScores = 0;
    }

    public void addTestScore(double earned)
    {
        totalScore += earned;
        numScores++;
    }

    public int getNumTestsTaken()
    {
        return numScores;
    }

    public double getAverage()
    {
        return totalScore / numScores;
    }

}
