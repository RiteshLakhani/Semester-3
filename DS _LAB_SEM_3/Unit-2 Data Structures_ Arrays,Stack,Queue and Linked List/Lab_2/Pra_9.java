import java.util.Scanner;

public class Pra_9
{
	public static void main(String[]args)
	{
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Number of Array: ");
		int a = sc.nextInt();

		int b[] = new int[a];

		System.out.println("Enter Array element: ");
		for(int i=0;i<a;i++)
		{
			b[i]=sc.nextInt();
		}

		System.out.println("Enterd element: ");
		for(int i=0;i<a;i++)
		{
			System.out.println(" "+b[i]);
		}
	}
}