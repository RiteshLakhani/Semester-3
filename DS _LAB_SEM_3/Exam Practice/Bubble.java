import java.util.Scanner;

public class Bubble
{
    public static void main(String[] args) 
    {
         Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter Aaary of size:");
        int size = sc.nextInt();

        int arr[] = new int[size];

        System.out.println("Enter Array Element:- ");
        for(int i=0;i<size;i++)
        {
            arr[i]=sc.nextInt();
        }

        System.out.println("Entered Array:- ");
        for(int i=0;i<size;i++)
        {
            System.out.println(" "+arr[i]);
        }

        boolean isSwapped;

        for(int i=0;i<arr.length-1;i++)
        {
            isSwapped = false;

            for(int j=0;j<arr.length-i-1;j++)
            {
                if(arr[j]>arr[j+1])
                {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    isSwapped = true;
                }
            }

            if(!isSwapped)
            {
                break;
            }
        }

        System.out.println("Sorted array:");
        for(int i=0;i<size;i++)
        {
            System.out.print(" "+arr[i]);
        }
    }
}