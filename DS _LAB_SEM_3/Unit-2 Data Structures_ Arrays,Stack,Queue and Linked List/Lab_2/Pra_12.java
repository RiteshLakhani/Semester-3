import java.util.Scanner;

public class Pra_12
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);

		int index = 0;
		System.out.println("Enter Number Of Array: ");
		int a = sc.nextInt();

		int b[] = new int[a];

		System.out.println("Enter Element of Array: ");
		for(int i=0;i<a;i++)
		{
			b[i]=sc.nextInt();
		}

		int min = b[0];

		for(int i = 0; i<a; i++) {
			if(min>b[i]) {
				min = b[i];
				index = i;
			}
		}

		System.out.println("Smallest Number: "+min);
		System.out.println("Smallest Number Index: "+index);
	}
}