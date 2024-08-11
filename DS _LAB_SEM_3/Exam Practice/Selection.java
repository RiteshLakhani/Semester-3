import java.util.Scanner;

public class Selection
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter Size Of Array:- ");
        int size = sc.nextInt();

        int array[] = new int[size];

        System.out.println("Enter Array Element:- ");
        for(int i=0;i<size;i++)
        {
            array[i]=sc.nextInt();
        }

        System.out.println("Entered Array:- ");
        for(int i=0;i<size;i++)
        {
            System.out.println(" "+array[i]);
        }

        //process
        for(int i=0;i<(array.length)-1;i++)
        {
            int minIndex = i;

            for(int j=i+1;j<array.length;j++)
            {
                if(array[j]<array[minIndex])
                {
                    minIndex = j;
                }
            }
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }

        System.out.println("Sorted array:");
        for(int i=0;i<size;i++)
        {
            System.out.print(" "+array[i]);
        }
    }
}
