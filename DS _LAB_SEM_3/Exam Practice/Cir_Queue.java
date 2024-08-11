import java.util.Scanner;

class CirQueueMain
{
    int size,front,rear;
    int [] queue;

    CirQueueMain(int size)
    {
        queue = new int[size];
        this.size = size;
        front = rear = -1;
    }

    public void insert(int n)
    {
        if(front ==0 && rear == size-1)
        {
            System.out.println("Queue Overflow");
        }
        else if(rear == front-1)
        {
            System.out.println("Queue Overflow");
        }
        else
        {
            if(front==-1 && rear==-1)
            {
                front = rear = 0;
            }
            else if(front>0 && rear == size-1)
            {
                rear = 0;
            }
            else
            {
                rear++;
            }
            queue[rear] = n;
        }
    }

    public int del()
    {
        if(front == -1 && rear == -1)
        {
            System.out.println("Circular Queue Is Empty");
            return 0;
        }
        else
        {
            int x = queue[front];
            if(front==rear)
            {
                front = rear = 0;
            }
            else if(front == size-1)
            {
                front = 0;
            }
            else
            {
                front++;
            }
            return x;
        }
    }

    public void display() 
    {
        if (front == -1 && rear == -1) 
        {
            System.out.println("Circular Queue Is Empty");
        }
        else 
        {
            if (rear < front) 
            {
                for (int i = front; i < size; i++) 
                {
                    System.out.print(queue[i] + " ");
                }
                for (int i = 0; i <= rear; i++) 
                {
                    System.out.print(queue[i] + " ");
                }
            } 
            else 
            {
                for (int i = front; i <= rear; i++) 
                {
                    System.out.print(queue[i] + " "); 
                }
            }
        System.out.println(); 
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
            System.out.println("Total Nodes of Elemetn in Cirucular Queue:- "+count);
        }
    }
}
public class Cir_Queue 
{
   public static void main(String[] args) 
   {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter The size of Cirucular Queue:-");
        int size = sc.nextInt();

        CirQueueMain qi = new CirQueueMain(size);

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
                        qi.display();
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