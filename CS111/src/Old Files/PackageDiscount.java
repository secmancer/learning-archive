import java.util.Scanner;

public class PackageDiscount
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of software packages to purchase");
        int packages = scanner.nextInt();

        double totalCost = 0.0;

        if (packages >= 10 && packages <= 19) {
            double regularTotal = 99.0 * packages;
            totalCost = regularTotal - (0.2 * regularTotal);
            System.out.println("Since you purchased " + packages + " packages, you earned a discount of 20%!");
            System.out.printf("Pre-discount total: $%,.2f\n", regularTotal);
        } else if (packages >= 20 && packages <= 49) {
            double regularTotal = 99.0 * packages;
            totalCost = regularTotal - (0.3 * regularTotal);
            System.out.println("Since you purchased " + packages + " packages, you earned a discount of 30%!");
            System.out.printf("Pre-discount total: $%,.2f\n", regularTotal);
        } else if (packages >= 50 && packages <= 99) {
            double regularTotal = 99.0 * packages;
            totalCost = regularTotal - (0.4 * regularTotal);
            System.out.println("Since you purchased " + packages + " packages, you earned a discount of 40%!");
            System.out.printf("Pre-discount total: $%,.2f\n", regularTotal);
        } else if (packages >= 100) {
            double regularTotal = 99.0 * packages;
            totalCost = regularTotal - (0.5 * regularTotal);
            System.out.println("Since you purchased " + packages + " packages, you earned a discount of 50%!");
            System.out.printf("Pre-discount total: $%,.2f\n", regularTotal);
        } else {
            totalCost = 99.0 * packages;
        }

        System.out.printf("Total cost: $%,.2f", totalCost);
    }
}
