import java.util.Scanner;

public class Queue2
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        
        Circular c1 = new Circular();

        int ch;

        do{
            System.out.println("Enter 0 For Exist");
            System.out.println("Enter 1 For insert");
            System.out.println("Enter 2 For display");
            System.out.println("Enter 3 For delete");

            System.out.println("Enter Choice: ");
            ch = sc.nextInt();

            switch(ch)
            {
                case 0 :
                            System.exit(0);
                case 1 :
                            c1.insert();
                            break;
                case 2 :
                            c1.display();
                            break;
                case 3 :
                            c1.del();
                            break;
                default : 
                            System.out.println("Enter valid Number ");
            }
        }while(ch!=0);
    }
}

class Circular
{
    static Scanner sc = new Scanner(System.in);
    int [ ] a = new int[5];
    int front=-1,rear=-1;

    public void insert()
    {
        if(rear==4)
	    {
    	    System.out.println("Queue is Full");
	    }
	    else
	    {   
		    if(front==-1 && rear==-1)
		    {
			    front++;
			    rear++;
		    }
		    else
		    {
			    rear++;
		    }
		    System.out.println("Enter Value: ");
		    a[rear] = sc.nextInt();
	    }
    }

    public void display()
    {
	    if(front==-1 && rear==-1)
	    {
		    System.out.println("Stack is Empty: ");	
	    }	
	    else
	    {
		    for(int i=front;i<=rear;i++)
		    {
			    System.out.println(" "+a[i]);
		    }
	    }
    }

    public void del()
    {
        if(front==-1 && rear==-1)
	    {
		    System.out.println("Stack is Empty");
	    }
	    else
	    {
		    if(front==rear)
		    {
			    front=-1;
			    rear=-1;
		    }
		    else
		    {
			    front++;
		    }
	    }
    }
}