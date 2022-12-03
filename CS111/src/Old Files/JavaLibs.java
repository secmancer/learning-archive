import java.util.Scanner;

public class JavaLibs
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a name");
        String name = scanner.nextLine();
        System.out.println("Enter an age");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter a city");
        String city = scanner.nextLine();
        System.out.println("Enter the name of a college");
        String college = scanner.nextLine();
        System.out.println("Enter a profession");
        String profession = scanner.nextLine();
        System.out.println("Enter an animal");
        String animal = scanner.nextLine();
        System.out.println("Enter a pet name");
        String petName = scanner.nextLine();
        System.out.println("Here's your story");

        System.out.println("There was once someone named " + name + " who lived in " + city + '.');
        System.out.println("At the age of " + age + ", " + name + " went to college at " + college + '.');
        System.out.println("After 4 years, " + name + " was " + (age + 4) + '.');
        System.out.println(name + " then graduated and went to work as a " + profession + '.');
        System.out.println("Then, " + name + " adopted a(n) " + animal + " named " + petName + '.');
        System.out.println("They both lived happily ever after!");
    }
}
