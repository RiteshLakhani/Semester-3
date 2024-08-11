import java.util.Scanner;

public class CircularQueue 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the Circular Queue: ");
        int size = sc.nextInt();

        Circular c1 = new Circular();
        c1.initializeQueue(size);

        int ch;

        do 
        {
            System.out.println("Enter 0 to Exit");
            System.out.println("Enter 1 to insert");
            System.out.println("Enter 2 to display");
            System.out.println("Enter 3 to delete");
            System.out.println("Enter 4 to Count Node");

            System.out.println("Enter choice: ");
            ch = sc.nextInt();

            switch (ch) 
            {
                case 0:
                    System.exit(0);
                case 1:
                    c1.insert();
                    break;
                case 2:
                    c1.display();
                    break;
                case 3:
                    c1.del();
                    break;
                case 4:
                    c1.count();
                    break;
                default:
                    System.out.println("Enter a valid number");
            }
        } while (ch != 0);
    }
}

class Circular
{
    static Scanner sc = new Scanner(System.in);
    int[] a;
    int front = -1;
    int rear = -1;
    int size;

    public void initializeQueue(int size) 
    {
        a = new int[size];
        this.size = size;
    }

    public void insert() 
    {
        if (front == 0 && rear == size - 1) 
        {
            System.out.println("Circular Queue is Full");
        } 
        else if (rear == front - 1) 
        {
            System.out.println("Circular Queue is Full");
        } 
        else 
        {
            if (front == -1 && rear == -1) 
            {
                front = 0;
                rear = 0;
            } 
            else if (front > 0 && rear == size - 1) 
            {
                rear = 0;
            } 
            else 
            {
                rear++;
            }

            System.out.println("Enter Number: ");
            a[rear] = sc.nextInt();
        }
    }

    public void display() 
    {
        if (front == -1 && rear == -1) 
        {
            System.out.println("Circular Queue is Empty");
        } 
        else 
        {
            if (rear < front) 
            {
                for (int i = front; i < size; i++) 
                {
                    System.out.print(a[i] + " ");
                }
                for (int i = 0; i <= rear; i++) 
                {
                    System.out.print(a[i] + " ");
                }
            } 
            else 
            {
                for (int i = front; i <= rear; i++) 
                {
                    System.out.print(a[i] + " ");
                }
            }
            System.out.println();
        }
    }

    public void del() 
    {
        if (front == -1 && rear == -1) 
        {
            System.out.println("Circular Queue is Empty");
        } 
        else 
        {
            if (front == rear) 
            {
                front = -1;
                rear = -1;
            } 
            else if (front == size - 1) 
            {
                front = 0;
            } 
            else 
            {
                front++;
            }
        }
    }

    public void count()
    {
        if(front==-1 && rear==-1)
        {
            System.out.println("Circular Queue Is Empty");
        }
        else
        {
            int count;

            if(front<=rear)
            {
                count = rear - front + 1;
            }
            else
            {
                count = size - front + rear + 1;
            }
            System.out.println("Number of Nodes in Circular Queue: " + count);
        }
    }
}
