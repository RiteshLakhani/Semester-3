import java.util.Scanner;

public class Pra_16_ArrayDeletion 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of elements in the array: ");
        int a = sc.nextInt();

        int[] b = new int[a];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i<a; i++) 
        {
            b[i] = sc.nextInt();
        }

        System.out.print("Enter the position to delete (index): ");
        int position = sc.nextInt();

        if (position<0 || position >= a) 
        {
            System.out.println("Invalid position entered.");
        } 
        else 
        {
            b = deleteNumber(b, position);
            System.out.println("Number deleted successfully.");
            System.out.println("Updated Array: ");
            for (int element : b) 
            {
                System.out.print(element + " ");
            }
        }
    }

    public static int[] deleteNumber(int[] b, int position) 
    {
        int newSize = b.length - 1;
        int[] newArray = new int[newSize];

        int newArrayIndex = 0;
        for (int i = 0; i < b.length; i++) 
        {
            if (i != position) 
            {
                newArray[newArrayIndex] = b[i];
                newArrayIndex++;
            }
        }

        return newArray;
    }
}
