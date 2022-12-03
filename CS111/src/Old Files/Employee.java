public class Employee
{
    private String name = "(not set)";
    private int idNumber = 0;
    private String department = "(not set)";
    private String position = "(not set)";

    public Employee() {}

    public Employee(String name, int idNumber)
    {
        this.name = name;
        this.idNumber = idNumber;
    }

    public Employee(String name, int idNumber, String department, String position)
    {
        this.name = name;
        this.idNumber = idNumber;
        this.department = department;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public String getPosition() {
        return position;
    }

    public int getIdNumber() {
        return idNumber;
    }
}
