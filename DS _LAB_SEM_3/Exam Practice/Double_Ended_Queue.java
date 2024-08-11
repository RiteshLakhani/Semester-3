import java.util.Scanner;

class CirQueueMain
{
    int size,front,rear;
    int [] queue;

    CirQueueMain(int size)
    {
        queue = new int[size];
        this.size = size;
        front=rear=-1;
    }

    public void insertRear(int n)
    {
        if(front==0 && rear==size-1)
        {
            System.out.println("Overflow");
        }
        else if(rear==front-1)
        {
            System.out.println("Overflow");
        }
        else
        {
            if(front==-1 && rear==-1)
            {
                front=rear=0;
            }
            else if(front>=0 && rear==size-1)
            {
                rear = 0;
            }
            else
            {
                rear++;
            }
            queue[rear]=n;
        }
    }

    public int delFront()
    {
        if(front==-1 && rear==-1)
        {
            System.out.println("Circular Queue is Empty");
            return 0;
        }
        else
        {
            int x = queue[front];
            if(front==rear)
            {
                front=-1;
                rear=-1;
            }
            else if(front==size-1)
            {
                front = 0;
            }
            else
            {
                front = front + 1;
            }
            return x;
        }
    }

    public void insertFront(int x)
    {
        if(front==0)
        {
            System.out.println("Circualr Queue is Full");
        } 
        else
        {
            if(front==-1 && rear==-1)
            {
                front=rear=0;
            }
            else
            {
                front--;
            }
            queue[front] = x;
        }
    }

    public int delRear()
    {
        if(front==-1 && rear==-1)
        {
            System.out.println("Circular Queue is empty");
            return 0;
        }
        else
        {
            int y = queue[rear];
            if(front==rear)
            {
                front=rear=-1;
            }
            else
            {
                rear--;
            }
            return y;
        }
    }

    public void display()
    {
        if(front==-1 && rear==-1)
        {
            System.out.println("Can't display");
        }
        else
        {
            if(rear<front)
            {
                for(int i=front;i<size;i++)
                {
                    System.out.print(queue[i]+" ");
                }
                for(int i=0;i<=rear;i++)
                {
                    System.out.print(queue[i]+" ");
                }
            }
            else
            {
                for(int i=0;i<=rear;i++)
                {
                    System.out.print(queue[i]+" ");
                }
            }
        }
    }

    public void count()
    {
        if(front == -1 && rear == -1) 
        {
            System.out.println("Circular Queue is Empty can't coount nodes");
        }
        else
        {
            int count;

            if(front<=rear)
            {
                count = rear-front+1;
            }
            else
            {
                count = size - front + rear + 1;
            }
            System.out.println("Total Number Of Node in Circular Queue: " + count);
        }
    }
}

public class Double_Ended_Queue
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Size of Queue: ");
        int size = sc.nextInt();

        CirQueueMain qi = new CirQueueMain(size);

        while(true)
        {
            System.out.println("Enter 1 for Insert Element from rear side:-");
            System.out.println("Enter 2 for Delete Element from front side:-");
            System.out.println("Enter 3 for Insert Element from front side:-");
            System.out.println("Enter 4 for delete Element from rear side:-");
            System.out.println("Enter 5 for Display:-");
            System.out.println("Enter 6 for Count the Element in Cirucular Queue:-");
            System.out.println("Enter 7 for Exist from the program:-");

            System.out.println("Enter Choice:-");
            int ch = sc.nextInt();

            switch(ch)
            {
                case 1:
                        System.out.println("Enter Element from add rear:- ");
                        int n = sc.nextInt();
                        qi.insertRear(n);
                        break;
                case 2:
                        qi.delFront();
                        break;
                case 3:
                        System.out.println("Enter Element from add front:- ");
                        int x = sc.nextInt();
                        qi.insertFront(x);
                        break;
                case 4:
                        qi.delRear();
                        break;
                case 5:
                        qi.display();
                        break;
                case 6:
                        qi.count();
                        break;
                case 7:
                        System.exit(0);
                        break;
                default:
                        System.out.println("Enter Valid Number......");
            }
            System.out.println("----------------------------------------------------------------");
            System.out.println("----------------------------------------------------------------");
        }
    }
    
}
