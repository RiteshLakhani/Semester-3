import java.util.Scanner;

class QueueImp 
{
    int front, rear, size;
    int[] queue;

    public void initializeQueue(int size) 
    {
        queue = new int[size];
        this.size = size;
        front = -1;
        rear = -1;
    }

    public void insert(int n) 
    {
        if (rear == size - 1) 
        {
            System.out.println("Queue is Full");
        } 
        else 
        {
            if (front == -1 && rear == -1) 
            {
                front = 0;
                rear = 0;
            } 
            else 
            {
                rear++;
            }
            queue[rear] = n;
            System.out.println("Pushed " + n + " onto the Queue.");    
        }
    }

    public String display() 
    {
        if (front == -1 && rear == -1) 
        {
            return "Queue is Empty";
        } 
        else 
        {
            String result = "";
            for (int i = front; i <= rear; i++) 
            {
                result += queue[i] + " ";
            }
            return result;
        }
    }


    public int del() 
    {
        if (front == -1 && rear == -1) 
        {
            System.out.println("Queue is Empty");
            return 0;
        } 
        else 
        {
            int deletedItem = queue[front];
            if (front == rear) 
            {
                front = -1;
                rear = -1;
            } 
            else 
            {
                front++;
            }
            return deletedItem;
        }
    }

    public void count()
    {
        if(front==-1 && rear==-1)
		{
			System.out.println("Queue is Empty..");
		}
		else
		{
			int count=0;

			for(int i=front;i<=rear;i++)
			{
				count = count + 1;
			}
			System.out.println("Total Number Of Node In Queue: "+count);
		}
    }
}

public class NQUEUE_DEQUEUE
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of Queue : ");
        int size = sc.nextInt();

        QueueImp qi = new QueueImp();
        qi.initializeQueue(size);

        int ch;

        System.out.println();

        do
        {
            System.out.println("Enter 0 to Exit");
            System.out.println("Enter 1 to Insert");
            System.out.println("Enter 2 to Display");
            System.out.println("Enter 3 to Delete");
            System.out.println("Enter 4 to Count");

            System.out.println("Enter choice: ");
            ch = sc.nextInt();

            switch (ch) 
            {
                case 0:
                    System.exit(0);
                    break;

                case 1:
                    System.out.print("Which element you want to push in Queue : ");
                    qi.insert(sc.nextInt());
                    break;

                case 2:
                    String queueElements = qi.display();
                    System.out.println("Queue is: " + queueElements);
                    break;

                case 3:
                    int n = qi.del();
                    System.out.println("Delete " + n + " from the Queue.");
                    break;
                
                case 4:
                    qi.count();
                    break;

                default:
                    System.out.println("Please enter a valid number");
            }
        } while (ch != 0);
    }
}
