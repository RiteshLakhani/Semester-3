import java.util.*;

public class Pra_19_Merge
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);

		//for 1st Array; 
		System.out.println("Enter Number of First Array:");
		int n = sc.nextInt();
		int a[] = new int[n];
		System.out.print("Enter First array Element: ");
		for(int i=0;i<n;i++)	
		{
			a[i]=sc.nextInt();
		}

		//for 2nd Array; 
		System.out.println("Enter Number of Second Array:");
		int m = sc.nextInt();
		int b[] = new int[m];
		System.out.print("Enter Second array Element: ");
		for(int i=0;i<m;i++)
		{
			b[i]=sc.nextInt();
		}

		//Ans Array;
		int ans[] = new int[n+m];

		for(int i=0;i<a.length;i++)
		{
			ans[i] = a[i];
		}

		for(int i=0;i<b.length;i++)
		{
			ans[a.length+i] = b[i];
		}

		//for sorted;
		Arrays.sort(ans);

		System.out.println("Merged Array: ");
		for(int i=0;i<ans.length;i++)
		{
			System.out.println(""+ans[i]);
		}
	}
}