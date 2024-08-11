import java.util.*;

class StackMain{

    int top, size;
    String[] stack;

    StackMain(int size) 
    {
        stack = new String[size];
        this.size = size;
        top = -1;
    }

    public void push(String n) 
    {
        if(top == size - 1) 
        {
            System.out.println("Stack Overflow.");
        } 
        else 
        {
            top++;
            stack[top] = n;
            System.out.println("Pushed " + n + " onto the stack.");
        }
    }

    public String pop() 
    {
        if (top <= -1) 
        {
            System.out.println("Stack Underflow.");
            return " ";
        } 
        else
        {
            System.out.println(stack[top] + " has been popped");
            return stack[top--];
        }
    }

    public String peek() 
    {
        if (top <= -1) 
        {
            System.out.println("Stack Underflow.");
            return "";
        } 
        else 
        {
            return stack[top];
        }
    }
}

class recognize
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter String : ");
        String str = input.nextLine();
        
        StackMain st = new StackMain(str.length() + 1);
        System.out.println();


        int i = 1;
        String next;
        st.push("c");
        next = Character.toString(str.charAt(0));

        while(!next.equals("c"))
        {
            if(next.equals(" "))
            {
                System.out.println("Invalid String");
                System.exit(0);
            }
            else
            {
                st.push(next);
                next = Character.toString(str.charAt(i));
                i++;
            }
        }

        while(!st.peek().equals("c"))
        {
            next = Character.toString(str.charAt(i));
            i++;

            String x = st.pop();

            if(!next.equals(x))
            {
                System.out.println("Invalid String");
                System.exit(0);
            }
        }

        next = Character.toString(str.charAt(i));
        i++;

        if(next.equals(""))
        {
            System.out.println("Valid String");
        }
        else{
            System.out.println("Invalid String");
        }
    }
}