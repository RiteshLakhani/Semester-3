import java.util.Scanner;

public class Pra_13
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Number of Array: ");
		int a = sc.nextInt();

		int b[] = new int[a];

		System.out.println("Enter Array  Element: ");
		for(int i=0;i<a;i++)
		{
			b[i]=sc.nextInt();
		}

		boolean isDuplicate = false;

		for(int i = 0; i<a; i++) 
		{
			for(int j = 0; j<a; j++)
			{
				if(i==j) 
				{
					continue;
				}

				if(b[i]==b[j]) 
					{
						System.out.println("Array contains Duplicate value.");
						isDuplicate = true;
						break;
					}
			}
			if(isDuplicate) 
			{
				break;
			}
		}
		if(!isDuplicate) {
			System.out.println("Array does not contain any duplicate value.");
		}


	}
}