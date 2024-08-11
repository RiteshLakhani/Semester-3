import java.util.Scanner;

public class Pra_14
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Number of Array: ");
		int a = sc.nextInt();

		int b[] = new int[a];

		System.out.println("Enter Array Element: ");
		for(int i=0;i<a;i++)
		{
			b[i]=sc.nextInt();
		}	

		System.out.println("Enter number to replace: ");
		int c =sc.nextInt();

		System.out.println("Enter new number :");
		int d=sc.nextInt();

		int temp=c;
		int index=0;

		for(int i=0;i<a;i++)
		{
			if(b[i]==c)
			{
				b[i]=d;
				index=i;
			}

		}

		System.out.println("New Array:");
		for(int i=0;i<a;i++)
		{
			System.out.println(" "+b[i]);
		}
		System.out.println("Index: "+index);
	}
}