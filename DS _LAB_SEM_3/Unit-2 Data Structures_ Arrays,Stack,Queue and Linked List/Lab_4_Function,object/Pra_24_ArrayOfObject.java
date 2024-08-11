import java.util.Scanner;

class Student_Detail 
{
    private int enrollmentNo;
    private String name;
    private int semester;
    private double cpi;

    public Student_Detail(int enrollmentNo, String name, int semester, double cpi) 
    {
        this.enrollmentNo = enrollmentNo;
        this.name = name;
        this.semester = semester;
        this.cpi = cpi;
    }

    public int getEnrollmentNo() 
    {
        return enrollmentNo;
    }

    public String getName() 
    {
        return name;
    }

    public int getSemester() 
    {
        return semester;
    }

    public double getCPI() 
    {
        return cpi;
    }
}


public class Pra_24_ArrayOfObject 
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Student_Detail[] students = new Student_Detail[5];

        for (int i = 0; i < students.length; i++) 
        {
            System.out.println("Enter details for Student " + (i + 1) + ":");

            System.out.print("Enrollment No: ");
            int enrollmentNo = sc.nextInt();
            sc.nextLine();

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Semester: ");
            int semester = sc.nextInt();

            System.out.print("CPI: ");
            double cpi = sc.nextDouble();

            students[i] = new Student_Detail(enrollmentNo, name, semester, cpi);
        }

        // Print the student details
        System.out.println("Student Details:");
        for (int i = 0; i < students.length; i++) {
            System.out.println("Student " + (i + 1) + ":");
            System.out.println("Enrollment No: " + students[i].getEnrollmentNo());
            System.out.println("Name: " + students[i].getName());
            System.out.println("Semester: " + students[i].getSemester());
            System.out.println("CPI: " + students[i].getCPI());
            System.out.println();
        }
    }
}

