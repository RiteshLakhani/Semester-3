import java.util.Scanner;

public class Pra_1
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Radius of the Cricle: ");
		double r = sc.nextDouble();

		double ans ;

		ans = Math.PI*r*r;

		System.out.println("Area of circle is : "+ans);	
	}
}