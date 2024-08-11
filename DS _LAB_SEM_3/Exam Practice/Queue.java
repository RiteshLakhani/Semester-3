import java.util.Scanner;

class QueueMain
{
    int size,front,rear;
    int [] queue;

    QueueMain(int size)
    {
        queue = new int[size];
        this.size = size;
        front = rear = -1;
    }

    public void insert(int n)
    {
        if(rear == size-1)
        {
            System.out.println("Queue is full");
        }
        else
        {
            if(front ==-1 && rear ==-1)
            {
                front = rear = 0;
            }
            else
            {
                rear++;
            }
            queue[rear]=n;
        }
    }

    public int del()
    {
        if(front == -1 && rear == -1)
        {
            System.out.println("Queue is Empty");
            return 0;
        }
        else
        {
            int x = queue[front];
            if(front == rear)
            {
                front = rear = -1;
            }
            else
            {  
                front++;
            }
            return x;
        }
    }

    public String display()
    {
        if(front == -1 && rear == -1)
        {
            return "Queue is Empty";
        }
        else
        {
            String ans = "";

            for(int i=front ; i<=rear;i++)
            {
                ans += queue[i]+" ";
            }
            return ans;
        }
    }

    public  void count()
    {
        if(front == -1 && rear == -1)
        {
            System.out.println("Queue is Empty");
        }
        else
        {
            int count = 0;
            for(int i=front;i<=rear;i++)
            {
                count = count + 1;
            }
            System.out.println("No of Elements in Queue is "+ count);
        }
    }
}
public class Queue 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter The Size of the Queue:");
        int size = sc.nextInt();

        QueueMain qi = new QueueMain(size);

        while(true)
        {
            System.out.println("Enter 1 for Insert Element in Queue:");
            System.out.println("Enter 2 for Delete Element in Queue:");
            System.out.println("Enter 3 for Count  Element in Queue:");
            System.out.println("Enter 4 for Display Element in Queue:");
            System.out.println("Enter 5 for exist.....");

            System.out.println("Enter Your Choice:-");
            int ch = sc.nextInt();

            switch(ch)
            {
                case 1:
                        System.out.println("Enter Element In Queue:- ");
                        int n = sc.nextInt();
                        qi.insert(n);
                        break;
                
                case 2:
                        qi.del();
                        break;
                
                case 3:
                        qi.count();
                        break;
                
                case 4:
                        System.out.println(qi.display());
                        break;

                case 5:
                        System.exit(0);
                        break;
                default:
                        System.out.println("Enter Valid Number in for Search....");
            }
            System.out.println("");
            System.out.println();
        }
    }
}
