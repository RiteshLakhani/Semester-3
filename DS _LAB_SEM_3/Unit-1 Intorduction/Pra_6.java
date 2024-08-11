import java.util.Scanner;

public class Pra_6
{
	public static void main(String[] args) 
	{
		
		
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter base Number: ");
		int a = sc.nextInt();

		System.out.println("Enter Power of number:");
		int b = sc.nextInt();

		int ans = 0 ;
		int temp = a ;


		for(int i=0; i<b-1; i++)
		{

			for(int j=0 ; j<a; j++)
			{
				ans=ans+temp;	
			}
			temp=ans;
			ans=0;		
		}

		System.out.println("Ans:"+temp);	
		
	}
}