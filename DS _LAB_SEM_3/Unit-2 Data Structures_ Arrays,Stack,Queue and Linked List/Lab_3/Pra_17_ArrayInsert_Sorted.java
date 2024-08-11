import java.util.*;

public class Pra_17_ArrayInsert_Sorted
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

		System.out.print("Enter Number to Insert in Sorted Array: ");
		int c = sc.nextInt();

		int[] updatedArray = new int[a+1];
        int insertIndex = 0;
        boolean inserted = false;

        for(int i=0;i<a;i++)
        {
        	if(b[i]>c && !inserted)
        	{
        		updatedArray[insertIndex]=c;
        		insertIndex++;
        		inserted=true;
        	}

        	updatedArray[insertIndex] = b[i];
            insertIndex++;
        }

        if(!inserted) 
        {
            updatedArray[a] = c;
        }
  
        System.out.println("Updated Array:");
		for (int i = 0; i < updatedArray.length; i++) 
		{
   			 System.out.println(updatedArray[i] + " ");
		}
	}
}