import java.util.Scanner;

public class Pra_11
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Number Of Array: ");
		int a = sc.nextInt();

		int b[] = new int[a];

		System.out.println("Enter Array Element: ");
		for(int i=0;i<a;i++)
		{
			b[i]=sc.nextInt();
		}

		int sum = 0;

		for(int i=0;i<a;i++)
		{
			sum = sum + b[i];
		}

		int avg = sum / a ;

		System.out.println("Sum: "+sum);
		System.out.println("Ans: "+avg);	
	}
}