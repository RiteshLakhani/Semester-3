import java.util.Scanner;

class QueueImp 
{
    static Scanner sc = new Scanner(System.in);
    int[] a = new int[5];
    int front = -1;
    int rare = -1;

    public void insert() 
    {
        if (rare == 4) 
        {
            System.out.println("Queue is Full");
        } 
        else 
        {
            if (front == -1 && rare == -1) 
            {
                front = front + 1;
                rare = rare + 1;
            } 
            else 
            {
                rare++;
                System.out.println("Enter Value: ");
                a[rare] = sc.nextInt();
            }
        }
    }

    public void display() 
    {
        if (front == -1 && rare == -1) 
        {
            System.out.println("Queue is Empty");
        } 
        else 
        {
            for (int i = front; i <= rare; i++) 
            {
                System.out.print(a[i] + " ");
            }
            System.out.println();
        }
    }

    public int del() 
    {
        if (front == -1 && rare == -1) 
        {
            System.out.println("Queue is Empty");
            return 0;
        } 
        else 
        {
            if (front == rare) 
            {
                front = -1;
                rare = -1;
            } 
            else 
            {
                front++;
                return a[front - 1];
            }
        }
        return 0;
    }
}

public class Queue1 {
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        QueueImp q1 = new QueueImp();
        int ch;

        do {
            System.out.println("Enter 0 to Exit");
            System.out.println("Enter 1 to Insert");
            System.out.println("Enter 2 to Display");
            System.out.println("Enter 3 to Delete");

            System.out.println("Enter choice: ");
            ch = sc.nextInt();

            switch (ch) 
            {
                case 0:
                    break;
                case 1:
                    q1.insert();
                    break;
                case 2:
                    q1.display();
                    break;
                case 3:
                    System.out.println(q1.del() + " has been deleted from the queue");
                    break;
                default:
                    System.out.println("Please enter a valid number");
            }
        } while (ch != 0);
    }
}
