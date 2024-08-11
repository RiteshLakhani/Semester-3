import java.util.Scanner;
import java.util.Arrays;

public class Binary {
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

        Arrays.sort(arr);

        System.out.println("Enter Element To Search:");
        int x = sc.nextInt();

        int left = 0;
        int right = size-1;
        boolean found = false;

        while(left<right)
        {
            int middle = (left+right)/2;

            if(x==arr[middle])
            {
                System.out.println("Value found at index" +middle);
                found = true;
                break;
            }
            else if(x < arr[middle])
            {
                right = middle -1; 
            }
            else
            {
                left = middle + 1;
            }
        }

        if(!found)
        {
            System.out.println("Value not found at any index");
        }
    }
}
