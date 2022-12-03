import java.util.Scanner;

public class BMICalc
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("== BMI Calculator ==");
        System.out.println("Step 1: Enter height");
        System.out.println("Feet:");
        int feet = scanner.nextInt();
        System.out.println("Inches:");
        int inches = scanner.nextInt();
        System.out.println("Step 2: Enter weight");
        System.out.println("Pounds:");
        int pounds = scanner.nextInt();

        double bmiScore = (pounds * 703) / Math.pow((feet * 12) + inches, 2);

        if (bmiScore > 29.9) {
            System.out.printf("BMI: %.1f, you are obese.\n", bmiScore);
        } else if (bmiScore >= 25.0 && bmiScore <= 29.9) {
            System.out.printf("BMI: %.1f, you are overweight.\n", bmiScore);
        } else if (bmiScore >= 18.5 && bmiScore <= 24.9) {
            System.out.printf("BMI: %.1f, you are normal.\n", bmiScore);
        } else if (bmiScore < 18.5) {
            System.out.printf("BMI: %.1f, you are underweight.\n", bmiScore);
        }
    }
}
