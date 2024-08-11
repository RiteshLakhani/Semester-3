import java.util.Scanner;

public class Shall{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter Size Of Array:-");
        int size = sc.nextInt();

        int arr[] = new int[size];

        System.out.println("Enter Array Element:-");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        int gap;

        for(gap = size/2 ; gap>=1;gap/=2)
        {
            for(int j = gap ; j<size;j++)
            {
                for(int i = j-gap ; i>=0 ; i-=gap)
                {
                    if(arr[i+gap]<arr[i])
                    {
                        int temp = arr[i+gap];
                        arr[i+gap] = arr[i];
                        arr[i]=temp;
                    }
                    else
                    {
                        break;
                    }
                }
            }
        }

        System.out.println("Sorted Array:-");
        for (int i = 0; i < size; i++) {
            System.out.println(" " + arr[i]);
        }
    }
}