import java.util.Scanner;

public class CoffeeShop
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many dollars will you spend?");
        int rawCoffees = scanner.nextInt();
        int totalCoffees = 0;
        int stars = 0;
        while (rawCoffees > 0) {
            stars++;
            totalCoffees++;
            rawCoffees--;
            if (stars == 7) {
                stars -= 6;
                totalCoffees++;
            }
        }
        System.out.println("Coffees: " + totalCoffees);
        System.out.println("Stars remaining: " + stars);
    }
}
