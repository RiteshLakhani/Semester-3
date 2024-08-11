import java.util.Scanner;

public class Pra_8
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter Number: ");
		int a = sc.nextInt();

		boolean isPrime = false;

		for(int i=2;i<a;i++)
		{
			if(a%i==0)
			{
				isPrime=true;
				break;
			}
		}

		if(!isPrime)
		{
			System.out.println(a+" Number is Prime");
		}
		else
		{
			System.out.println(a+" Number is not prime");
		}	
	}
}