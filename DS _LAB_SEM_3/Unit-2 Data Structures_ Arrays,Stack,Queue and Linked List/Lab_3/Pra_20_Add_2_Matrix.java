import java.util.Scanner;

public class Pra_20_Add_2_Matrix 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        int arr1[][] = new int[2][2];
        System.out.println("Enter 1st Matrix Element: ");
        for (int i = 0; i < arr1.length; i++) 
        {
            for (int j = 0; j < arr1[i].length; j++) 
            {
                arr1[i][j] = sc.nextInt();
            }
        }

        int arr2[][] = new int[2][2];
        System.out.println("Enter 2nd Matrix Element: ");
        for (int i = 0; i < arr2.length; i++) 
        {
            for (int j = 0; j < arr2[i].length; j++) 
            {
                arr2[i][j] = sc.nextInt();
            }
        }

        int[][] ans = new int[2][2];
        for (int i = 0; i < ans.length; i++) 
        {
            for (int j = 0; j < ans[i].length; j++) 
            {
                ans[i][j] = arr1[i][j] + arr2[i][j];
            }
        }

        System.out.println("Addition of 2 matrices: ");
        for (int i = 0; i < ans.length; i++) 
        {
            for (int j = 0; j < ans[i].length; j++) 
            {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}
