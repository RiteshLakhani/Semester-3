import java.util.Scanner;

public class Lab_5_30_B 
{    
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter String: ");
        String str = sc.nextLine();

        StackMain st = new StackMain(str.length() + 1);
        boolean isValid = true;

        for (int i = 0; i < str.length(); i++) 
        {
            char ch = str.charAt(i);

            if (ch == 'a') 
            {
                st.push("a");
            } 
            else if (ch == 'b') 
            {
                if (st.isEmpty() || !st.pop().equals("a")) 
                {
                    isValid = false;
                    break;
                }
            } 
            else 
            {
                isValid = false;
                break;
            }
        }

        if(isValid && st.isEmpty()) 
        {
            System.out.println("The string is of the form a^ib^i.");
        } 
        else 
        {
            System.out.println("The string is not of the form a^ib^i.");
        }
    }
}

class StackMain 
{
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
        if (top == size - 1) 
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
        if (top == -1) 
        {
            System.out.println("Stack Underflow.");
            return null;
        } 
        else 
        {
            System.out.println(stack[top] + " has been popped");
            return stack[top--];
        }
    }

    public boolean isEmpty() 
    {
        return top == -1;
    }
}