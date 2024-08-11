import java.util.*;

public class Pra_18_ArrayElement_Delete
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter Number of Array: ");
		int a = sc.nextInt();

		int b[] = new int [a];

		System.out.println("Enter Array Element: ");
		for(int i=0;i<a;i++)
		{
			b[i]=sc.nextInt();
		}

		Arrays.sort(b);

		System.out.println("Sorted Array: ");
		for(int i=0;i<a;i++)
		{
			System.out.println(""+b[i]);
		}

		System.out.print("Enter the delete Number in Array: ");
		int c = sc.nextInt();

		int loc = -1;
        for (int i = 0; i < a; i++) 
        {
            if (b[i] == c) 
            {
                loc = i;
                break;
            }
        }

        if (loc == -1) 
        {
            System.out.println("Number not found in the array.");
        } 
        else 
        {
            for (int i=loc+1;i<a;i++) 
            {
                b[i - 1] = b[i];
            }
            a--;

            System.out.println("Array after deleting the number: ");
            for (int i = 0; i < a; i++) 
            {
                System.out.println("" + b[i]);
            }
        }
	}
}

