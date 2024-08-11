import java.util.Scanner;

public class QuickSort
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter Size Of Array:- ");
        int size = sc.nextInt();

        int [] arr = new int[size];

        System.out.println("Enter Array Element:-");
        for(int i=0;i<size;i++)
        {
            arr[i]=sc.nextInt();
        }

        quickSort(arr,0,size-1);

        System.out.println("Sorted Array:-");
        for(int i=0;i<size;i++)
        {
            System.out.print(" "+arr[i]);
        }
    }

    public static void quickSort(int arr[], int lb , int up)
    {
        if(lb<up)
        {
            int pivotIndex = quickSortPartition(arr,lb,up);
            quickSort(arr,lb,pivotIndex-1);
            quickSort(arr,pivotIndex+1,up);
        }
    }

    public static int quickSortPartition(int []arr,int lb , int up)
    {
        int pivot = arr[lb];
        int i = lb;

        for(int j=lb+1 ; j<=up ; j++)
        {
            if(arr[j]<pivot)
            {
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i];
        arr[i] = arr[lb];
        arr[lb] = temp;

        return i;
    }
}
