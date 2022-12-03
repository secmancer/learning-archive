import java.util.Scanner;

public class CookieRecipe
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many batches of cookies do you want?");
        int batchNumber = scanner.nextInt();
        System.out.println(batchNumber + " batches? That's " + (batchNumber * 48) + " cookies.");
        System.out.println("Alright, here is what you need");
        double totalSugar = batchNumber * 1.5;
        double totalButter = batchNumber * 1.0;
        double totalFlour = batchNumber * 2.75;
        System.out.println(totalSugar + " cups of sugar");
        System.out.println(totalButter + " cup of butter");
        System.out.println(totalFlour + " cups of flour");
    }
}
