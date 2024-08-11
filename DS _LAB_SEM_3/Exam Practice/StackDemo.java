import java.util.Scanner;

class StackMain{

    int top,size;
    int [] stack;

    StackMain(int size)
    {
        stack = new int[size];
        this.size = size;
        top = -1;
    }

   public void push(int x) 
   {
        if (top == size - 1) 
        {
            System.out.println("Stack Overflow");
        }
        else 
        {
            top++;
            stack[top] = x;
            System.out.println("Element " + x + " is pushed onto the Stack");
        }
    }
    
    public int pop()
    {
        if(top==-1)
        {
            System.out.println("Stack Underflow");
            return -1;
        }
        else
        {
            return stack[top--];
        }
    }

    public void peep(int i)
    {
        if(top==-1)
        {
            System.out.println("Stack Underflow");
        }
        else
        {
            System.out.println("Element at index "+stack[i]);
        }
    }

    public void change(int position , int n)
    {  
       if(top==-1)
       {
            System.out.println("Stack Underflow");
       } 
       if(position<0 || position>top)
       {
            System.out.println("Invalid Postion");
       }
       else
       {
            stack[top-position] = n;
            System.out.println("Changed position " + position + " to " + n);
       }
    }

    public void peek()
    {
        if(top==-1)
        {
            System.out.println("Stack Underflow");
        }
        else
        {
            System.out.println(stack[top]+" is top Of the Element of Stack");
        }
    }

    public void count()
    {
        int count = 0 ;

        if(top==-1)
        {
            System.out.println("Stack Underflow");
        }
        else
        {
            for(int i=top;i>=0;i--)
            {
                count = count + 1 ;
            }
        }

        System.out.println("Total Element: "+count);
    }

    public void display()
    {
        if(top==-1)
        {
            System.out.println("Stack Underflow");
        }
        else
        {
            for(int i=top;i>=0;i--)
            {
                System.out.print(" "+stack[i]);
            }
        }
    }
}

public class StackDemo{

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Size of Stack:");
        int size = sc.nextInt();

        StackMain st = new StackMain(size);

        System.out.println("  ");

        while(true)
        {
            System.out.println("Enter 1 For Push:-");
            System.out.println("Enter 2 For PoP:-");
            System.out.println("Enter 3 For Peek:-");
            System.out.println("Enter 4 For Peep:-");
            System.out.println("Enter 5 For Change:-");
            System.out.println("Enter 6 For Count:-");
            System.out.println("Enter 7 For Display:-");
            System.out.println("Enter 8 For Exist from the Program:-");

            System.out.println("Enter Your Choice:-");
            int ch = sc.nextInt();

            switch(ch)
            {
                case 1:
                        System.out.println("Enter Element To push into The Stack:- ");
                        int x = sc.nextInt();
                        st.push(x);
                        break;
                
                case 2:
                        int n = st.pop();
                        System.out.println("Popped element is "+n);
                        break;
                
                case 3:
                        System.out.println("Enter Index Of the Element:-");
                        int index = sc.nextInt();
                        st.peep(index);
                        break;
                
                case 4:
                        System.out.println("Entet Index to Chnage Position :- ");
                        int position = sc.nextInt();

                        System.out.println("Enter New Element :- ");
                        int newElement = sc.nextInt();

                        st.change(position, newElement);
                        break;
                case 5:
                        st.peek();
                        break;
                case 6:
                        st.count();
                        break;
                case 7:
                        st.display();
                        break;
                case 8:
                        System.exit(0);
                        break;
                default:
                        System.out.println("Enter Number is Invalid Please Enter Valid Number:-");
            }
        }
    }
}
