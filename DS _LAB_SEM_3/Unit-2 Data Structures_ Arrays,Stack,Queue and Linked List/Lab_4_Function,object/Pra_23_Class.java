import java.util.Scanner;

public class Pra_23_Class 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Employee_Id: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter Employee_Name: ");
        String names = sc.nextLine();

        System.out.println("Enter Employee_Designation: ");
        String desig = sc.nextLine();

        System.out.println("Enter Employee_Salary: ");
        double sal = sc.nextDouble();

        Employee_Detail e1 = new Employee_Detail(id, names, desig, sal);

        System.out.println("Employee Details:");
        System.out.println("Employee_Id: " + e1.Employee_Id);
        System.out.println("Employee_Name: " + e1.name);
        System.out.println("Employee_Designation: " + e1.designation);
        System.out.println("Employee_Salary: " + e1.salary);
    }
}

class Employee_Detail 
{
    int Employee_Id;
    String name;
    String designation;
    double salary;

    public Employee_Detail(int Employee_Id, String name, String designation, double salary) 
    {
        this.Employee_Id = Employee_Id;
        this.name = name;
        this.designation = designation;
        this.salary = salary;
    }
}
