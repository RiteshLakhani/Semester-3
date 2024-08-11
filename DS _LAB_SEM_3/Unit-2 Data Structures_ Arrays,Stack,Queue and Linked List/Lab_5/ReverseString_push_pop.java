import java.util.Scanner;

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
        if (top <= -1) 
        {
            System.out.println("Stack Underflow.");
            return "";
        } 
        else 
        {
            System.out.println(stack[top] + " has been popped");
            return stack[top--];
        }
    }
}

public class ReverseString_push_pop 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a string to reverse: ");
        String inputString = sc.nextLine();

        String reversedString = reverseString(inputString);
        System.out.println("Original String: " + inputString);
        System.out.println("Reversed String: " + reversedString);
    }

    public static String reverseString(String inputString) 
    {
        int length = inputString.length();
        StackMain stack = new StackMain(length);

        // Push each character of the input string onto the stack
        for (int i = 0; i < length; i++) 
        {
            stack.push(String.valueOf(inputString.charAt(i)));
        }

        char[] reversedChars = new char[length];

        // Pop characters from the stack to build the reversed string
        for (int i = 0; i < length; i++) 
        {
            reversedChars[i] = stack.pop().charAt(0);
        }

        return new String(reversedChars);
    }
}
