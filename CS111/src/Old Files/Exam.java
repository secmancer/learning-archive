public class Exam
{
    public static double getAverage(double d1, double d2, double d3, double d4, double d5)
    {
        return (d1 + d2 + d3 + d4 + d5) / 5;
    }

    public static char determineGrade(double avg)
    {
        char letterGrade = ' ';
        if (avg >= 90.0)
        {
            letterGrade = 'A';
        } else if (avg >= 80 && avg <= 89)
        {
            letterGrade = 'B';
        } else if (avg >= 70 && avg <= 79) {
            letterGrade = 'C';
        } else if (avg >= 60 && avg <= 69)
        {
            letterGrade = 'D';
        } else if (avg <= 59)
        {
            letterGrade = 'F';
        }
        return letterGrade;
    }
}
