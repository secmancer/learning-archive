import java.util.Scanner;

public class IngredientParser
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ingredients");
        String input = scanner.nextLine();

        String[] arrowFiltered = input.split(">");

        for (int i = 0; i < arrowFiltered.length; i++)
        {
            if (!arrowFiltered[i].contains(":")) {
                System.out.println(arrowFiltered[i].trim());
            }
            else
            {
                String newInput = arrowFiltered[i];
                String[] colonFiltered = newInput.split(":");

                for (int j = 0; j < colonFiltered.length; j++)
                {
                    System.out.println(colonFiltered[j].trim());
                }
            }
        }
    }
}
