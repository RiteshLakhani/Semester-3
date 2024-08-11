import java.util.Scanner;

public class Dequeue 
{
    public static void main(String[]args)
    {
        Scanner sc = new Scanner(System.in);

        dequeueimp d1 = new dequeueimp();

        int ch; 

        do
        {
            System.out.println("Enter 0 For Exist");
            System.out.println("Enter 1 For addRear");
            System.out.println("Enter 2 For delFront");
            System.out.println("Enter 3 For display");
            System.out.println("Enter 4 For addFront");
            System.out.println("Enter 5 For delRear");

            System.out.println("Enter choice: ");
            ch = sc.nextInt();

            switch(ch)
            {
                case 0 :
                        break;
                case 1 :
                        d1.addRear();
                        break;
                case 2 :
                        d1.delFront();
                        break;
                case 3 :
                        d1.display();
                        break;
                case 4 :
                        d1.addFront();
                        break;
                case 5 :
                        d1.delRear();
                        break;
                default :
                        System.out.println("Enter Valid Number...");
            }
        }while(ch!=0);
    }
}

class dequeueimp
{
    int [] a= new int [5];
    int front=-1,rear=-1;

    static Scanner sc = new Scanner(System.in);

    public void addRear()
    {
        if(rear==4)
	    {
	        System.out.println("Dequeue is Full");
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
    
    public void delFront()
    {
	   
	    if(front==-1 && rear==-1)
	    {
		    System.out.println("Dequeue is Empty");
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
    public void display()
    {
         if(front==-1 && rear==-1)
	    {
		    System.out.println("DeQueue is Empty: ");	
	    }	
	    else
	    {
		    for(int i=front;i<=rear;i++)
		    {
			    System.out.println(" "+a[i]);
		    }
	    }
    }
    public void addFront()
    {
        if(front==0)
	    {   
		    System.out.println("Dequeue is Full");
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
			    front=front-1;
		    }
		    System.out.println("Enter Value: ");
		    a[front] = sc.nextInt();
	    }
    }
    public void delRear()
    {
        if(front==-1 && rear==-1)
	    {
		    System.out.println("Dequeue is Empty...");
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
			    rear=rear-1;
		    }
	    }
    }
}