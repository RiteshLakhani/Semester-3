import java.util.Scanner;

class stack
{
    static Scanner sc = new Scanner(System.in);
    int[] a = new int[5];
    int top=-1;

    public void push()
    {
        if(top==4)
        {
            System.out.println("Stack is Full");
        }
        else
        {
            top++;
            System.out.println("Enter Value Into Stack: ");
            a[top] = sc.nextInt();
        }
    }
    public void display()
    {
        if(top==-1)
        {
            System.out.println("Stack is Empty");
        }
        else
        {
            for(int i=top;i>=0;i--)
            {
                System.out.println(" "+a[i]);
            }
        }
    }
    public int pop()
    {
        if(top==-1)
        {
            System.out.println("Stack is Empty");
            return 0;
        }
            return a[top--];
    }
    public void count()
    {
        int count=0;
        if(top==-1)
        {
            System.out.println("Stack is Empty");
        }
        else
        {
            for(int i=top;i>=0;i--)
            {
                count++;
            }
            System.out.println("Total Number Of Value: "+count);
        }
    }
    public void peep()
    {
        if(top==-1)
        {
            System.out.println("Stack is Empty");
        }
        else
        {
            System.out.println("Enter Value: ");
            int n = sc.nextInt();
            
            int flag=0;

            for(int i=top;i>=0;i--)
            {
                if(a[i]==n)
                {
                    flag = 1;
                    break;
                }
            }
                
            if(flag==1)
		    {
			    System.out.println("Enter Value is Found");
		    }
		    else
		    {
			    System.out.println("Enter Value is Not Found");
		    }
        }
    }
    public void update()
    {
         int flag = 0;

        if (top == -1)
        {
            System.out.println("Stack is empty");
        }
        else
        {
            System.out.println("Enter Value: ");
            int n = sc.nextInt();

            for (int i = top; i >= 0; i--)
            {
                if (a[i] == n)
                {
                    flag = 1;

                    System.out.println(" Enter New Value to add: ");
                    int newVal= sc.nextInt();

                    a[i] = newVal;
                    break;
                }
            }
            
            if (flag == 0)
            {
                System.out.println("Value not found...");
            }
        }
    }
}
public class Stack_implementation
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        stack s1 = new stack();

        int ch;

        do
        {
            System.out.println("Enter 0 For Exit: ");
            System.out.println("Enter 1 For Push: ");
            System.out.println("Enter 2 For Display: ");
            System.out.println("Enter 3 For POP: ");
            System.out.println("Enter 4 For COUNT: ");
            System.out.println("Enter 5 For Value Present or Not: ");
            System.out.println("Enter 6 For Change: ");

            System.out.println("Enter choice: ");
            ch = sc.nextInt();

        switch(ch)
		    {
			    case 0 : 
					break;
						
			    case 1 :
					s1.push();
					break;
						
			case 2 : 
					s1.display();
					break;
						
			case 3 : 
                    System.out.println(" ");
				    System.out.println(s1.pop() + " Has been Popped");
                    System.out.println(" ");

					break;
			
			case 4 : 
					s1.count();
					break;
			
			case 5 :
					s1.peep();
					break;
			
			case 6: 
					s1.update();
					break;
			
			default: 	
					System.out.println("Enter Valid Number:");
		}
	}while(ch!=0);    
   }
}