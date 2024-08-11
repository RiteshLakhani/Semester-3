import java.util.Scanner;

public class CircularQueue 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        int ch;

        Circular c1 = new Circular();

        do 
        {
            System.out.println(" Enter 0 to Exit");
            System.out.println(" Enter 1 to insert");
            System.out.println(" Enter 2 to display");
            System.out.println(" Enter 3 to delete");

            System.out.println(" Enter choice: ");
            ch = sc.nextInt();

            switch (ch) 
            {
                case 0:
                    System.exit(1);

                case 1:
                    c1.insert();
                    break;
                case 2:
                    c1.display();
                    break;
                case 3:
                    c1.del();
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
    int[] a = new int[5];
    int front = -1;
    int rare = -1;

    public void insert() 
    {
        Scanner sc = new Scanner(System.in);

        if (front == 0 && rare == 4) 
        {
            System.out.println("Circular Queue is Full ");
        } 
        else if(rare==front-1) 
        {
            System.out.println("Circular Queue is Full ");
        } 
        else 
        {
            if (front == -1 && rare == -1) 
            {
                front++;
                rare++;
            } 
            else if (front > 0 && rare == 4) 
            {
                rare = 0;
            } 
            else 
            {
                rare++;
            }
            System.out.println(" Enter Number: ");
            a[rare] = sc.nextInt();
        }
    }

    public void display() 
    {
        if (front==-1 && rare==-1) 
        {
            System.out.println(" CircularQueue is Empty");
        } 
        else 
        {
            if (rare < front) 
            {
                for (int i = front; i <= 4; i++) 
                {
                    System.out.println(a[i] + " ");
                }
                for (int i = 0; i <= rare; i++) 
                {
                    System.out.println(a[i] + " ");
                }
            }
            else 
            {
                for (int i = front; i <= rare; i++) 
                {
                    System.out.println(" "+a[i]);
                }
            }
        }
    }

    public void del()
    {
        if(front==-1 && rare==-1)
	    {
		    System.out.println("Circular Queue is Empty..");
	    }
	    else
	    {
		    if(front==rare)
		    {
			    front=-1;
			    rare=-1;
		    }
		    else if(front==4 && rare>=0)
		    {
			    front=0;
		    }
		    else
		    {
			    front++;
		    }
        }
	}
}
