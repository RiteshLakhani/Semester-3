import java.util.Scanner;

public class Pra_15_ArrayInsertion 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of elements in the array: ");
        int a = sc.nextInt();

        int[] b = new int[a];

        System.out.println("Enter the elements of the array:");
        for (int i = 0;i<a;i++) 
        {
            b[i] = sc.nextInt();
        }

        System.out.print("Enter the number to insert: ");
        int c = sc.nextInt();

        System.out.print("Enter the position to insert (index): ");
        int d = sc.nextInt();

        if (d<0 || d>a) 
        {
            System.out.println("Invalid position entered.");
        } 
        else 
        {
            b = insertNumber(b, c, d);
            System.out.println("Number inserted successfully.");
            System.out.println("Updated Array: ");
            for (int element : b) {
                System.out.print(element + " ");
            }
        }
    }

    public static int[] insertNumber(int[] b, int c, int d) 
    {
        int newSize = b.length + 1;
        int[] newArray = new int[newSize];

        for (int i = 0; i < newSize; i++) 
        {
            if (i < d) 
            {
                newArray[i] = b[i];
            } 
            else if (i == d) 
            {
                newArray[i] = c;
            } 
            else 
            {
                newArray[i] = b[i - 1];
            }
        }

        return newArray;
    }
}
