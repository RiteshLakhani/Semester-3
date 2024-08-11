import java.util.Scanner;

public class Pra_5
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Number: ");
		int a = sc.nextInt();

		int ans=0;

		ans=findFactorail(a);
		System.out.println("Ans: "+ans);	
	}

	public static int findFactorail(int a)
	{

		if(a==0)
		{
			return 0;
		}
		
		if(a<=1)
		{
			return 1;
		}
		else
		{
			return a*findFactorail(a-1);
		}
	}	
}