import java.util.Scanner;

public class EmployeeTable
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("-- Employee Entry Form --");
        System.out.println("Enter name");
        String name = scanner.nextLine();
        System.out.println("Enter ID");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter department");
        String dep = scanner.nextLine();
        System.out.println("Enter position");
        String pos = scanner.nextLine();
        Employee employee1 = new Employee(name, id, dep, pos);
        System.out.println("-- Employee Entry Form --");
        System.out.println("Enter name");
        name = scanner.nextLine();
        System.out.println("Enter ID");
        id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter department");
        dep = scanner.nextLine();
        System.out.println("Enter position");
        pos = scanner.nextLine();
        Employee employee2 = new Employee(name, id, dep, pos);
        System.out.println("-- Employee Entry Form --");
        System.out.println("Enter name");
        name = scanner.nextLine();
        System.out.println("Enter ID");
        id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter department");
        dep = scanner.nextLine();
        System.out.println("Enter position");
        pos = scanner.nextLine();
        Employee employee3 = new Employee(name, id, dep, pos);
        System.out.println("        Name           ID   Department     Position");
        String nameFormat = "";
        if (employee1.getName().length() == 10)
        {
            nameFormat = "  " + employee1.getName() + "         ";
        }
        else if (employee1.getName().length() == 9)
        {
            nameFormat = "   " + employee1.getName() + "         ";
        }
        else if (employee1.getName().length() == 5)
        {
            nameFormat = "       " + employee1.getName() + "         ";
        }
        else if (employee1.getName().length() == 4)
        {
            nameFormat = "        " + employee1.getName() + "         ";
        }
        else if (employee1.getName().length() == 3)
        {
            nameFormat = "         " + employee1.getName() + "         ";
        }
        String depFormat = "";
        if (employee1.getDepartment().length() == 11)
        {
            depFormat = "  " + employee1.getDepartment();
        }
        else if (employee1.getDepartment().length() == 8)
        {
            depFormat = "     " + employee1.getDepartment();
        }
        String posFormat = "";
        if (employee1.getPosition().length() == 11)
        {
            posFormat = "  " + employee1.getPosition();
        }
        else if (employee1.getPosition().length() == 9)
        {
            posFormat = "    " + employee1.getPosition();
        }
        else if (employee1.getPosition().length() == 8)
        {
            posFormat = "     " + employee1.getPosition();
        }
        else if (employee1.getPosition().length() == 3)
        {
            posFormat = "          " + employee1.getPosition();
        }
        System.out.println(nameFormat + employee1.getIdNumber() + depFormat + posFormat);

        if (employee2.getName().length() == 10)
        {
            nameFormat = "  " + employee2.getName() + "         ";
        }
        else if (employee2.getName().length() == 9)
        {
            nameFormat = "   " + employee2.getName() + "         ";
        }
        else if (employee2.getName().length() == 5)
        {
            nameFormat = "       " + employee2.getName() + "         ";
        }
        else if (employee2.getName().length() == 4)
        {
            nameFormat = "        " + employee2.getName() + "         ";
        }
        else if (employee2.getName().length() == 3)
        {
            nameFormat = "         " + employee2.getName() + "         ";
        }
        if (employee2.getDepartment().length() == 11)
        {
            depFormat = "  " + employee2.getDepartment();
        }
        else if (employee2.getDepartment().length() == 8)
        {
            depFormat = "     " + employee2.getDepartment();
        }
        if (employee2.getPosition().length() == 11)
        {
            posFormat = "  " + employee2.getPosition();
        }
        else if (employee2.getPosition().length() == 9)
        {
            posFormat = "    " + employee2.getPosition();
        }
        else if (employee2.getPosition().length() == 8)
        {
            posFormat = "     " + employee2.getPosition();
        }
        else if (employee2.getPosition().length() == 3)
        {
            posFormat = "          " + employee2.getPosition();
        }
        System.out.println(nameFormat + employee2.getIdNumber() + depFormat + posFormat);

        if (employee3.getName().length() == 10)
        {
            nameFormat = "  " + employee3.getName() + "         ";
        }
        else if (employee3.getName().length() == 9)
        {
            nameFormat = "   " + employee3.getName() + "         ";
        }
        else if (employee3.getName().length() == 5)
        {
            nameFormat = "       " + employee3.getName() + "         ";
        }
        else if (employee3.getName().length() == 4)
        {
            nameFormat = "        " + employee3.getName() + "         ";
        }
        else if (employee3.getName().length() == 3)
        {
            nameFormat = "         " + employee3.getName() + "         ";
        }
        if (employee3.getDepartment().length() == 11)
        {
            depFormat = "  " + employee3.getDepartment();
        }
        else if (employee3.getDepartment().length() == 8)
        {
            depFormat = "     " + employee3.getDepartment();
        }
        if (employee3.getPosition().length() == 11)
        {
            posFormat = "  " + employee3.getPosition();
        }
        else if (employee3.getPosition().length() == 9)
        {
            posFormat = "    " + employee3.getPosition();
        }
        else if (employee3.getPosition().length() == 8)
        {
            posFormat = "     " + employee3.getPosition();
        }
        else if (employee3.getPosition().length() == 3)
        {
            posFormat = "          " + employee3.getPosition();
        }
        System.out.println(nameFormat + employee3.getIdNumber() + depFormat + posFormat);
    }
}
