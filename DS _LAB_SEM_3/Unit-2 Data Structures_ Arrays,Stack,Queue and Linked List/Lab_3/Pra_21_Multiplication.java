import java.util.Scanner;

public class Pra_21_Multiplication
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);

		int a[][] = new int [3][2];
		System.out.print("Enter First Matrix Element: ");
		for(int i=0;i<a.length;i++)
		{
			for(int j=0;j<a[i].length;j++)
			{
				a[i][j] = sc.nextInt();
			}
		}

		int b[][] = new int [2][3];
		System.out.print("Enter Second Matrix Element: ");
		for(int i=0;i<b.length;i++)
		{
			for(int j=0;j<b[i].length;j++)
			{
				b[i][j] = sc.nextInt();
			}
		}

        int result[][] = new int[a.length][b[0].length];
        for (int i = 0; i < a.length; i++) 
        {
            for (int j = 0; j < b[0].length; j++) 
            {
                for (int k = 0; k < a[0].length; k++) 
                {
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }

        System.out.println("Multiplication Result:");
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
	}		
}