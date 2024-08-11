import java.util.Scanner;

public class LinearSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Size Of Array:-");
        int size = sc.nextInt();

        int arr[] = new int [size];

        System.out.println("Enter Array Element:-");
        for(int i=0;i<size;i++)
        {
            arr[i] = sc.nextInt();
        }

        System.out.println("Enter Number to Search In Array:-");
        int x = sc.nextInt();

        boolean flage = false;
        int index=0;

        for(int i=0;i<=arr.length;i++)
        {
            if(arr[i]==x)
            {
                flage = true;
                index = i;
                break;
            }
        }

        if(flage)
        {
            System.out.println("Element Found At index " + index);
        }
        else
        {
            System.out.println("Element Not Found");
        }
    }   
}
