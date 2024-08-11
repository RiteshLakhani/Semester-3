import java.util.Scanner;

class Stack 
{
    private Node top;
    private int maxSize;
    private int count; 

    private static class Node 
    {
        int data;
        Node next;

        Node(int data) 
        {
            this.data = data;
            this.next = null;
        }
    }

    public Stack(int maxSize) 
    {
        this.maxSize = maxSize;
        this.count = 0;
        this.top = null;
    }

    public boolean isEmpty() 
    {
        return top == null;
    }

    public boolean isFull() 
    {
        return count == maxSize;
    }

    public void push(int data) 
    {
        if (isFull()) 
        {
            throw new IllegalStateException("Stack Overflow");
        }
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
        count++;
    }

    public int pop() 
    {
        if (isEmpty()) 
        {
            throw new IllegalStateException("Stack Underflow");
        }
        int data = top.data;
        top = top.next;
        count--;
        return data;
    }

    public int peek() 
    {
        if (isEmpty()) 
        {
            throw new IllegalStateException("Stack is empty");
        }
        return top.data;
    }

    public void display() 
    {
        Node current = top;
        while (current != null) 
        {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

public class stack_by_linkedlist
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the maximum size of the stack: ");
        int maxSize = sc.nextInt();
        Stack st = new Stack(maxSize);

        int ch;
        int data;

        do {
            System.out.println("Menu:");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Enter the data to push: ");
                    data = sc.nextInt();
                    try {
                        st.push(data);
                        System.out.println("Pushed " + data + " into the stack.");
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2:
                    try {
                        int poppedElement = st.pop();
                        System.out.println("Popped element: " + poppedElement);
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    try {
                        int topElement = st.peek();
                        System.out.println("Top element: " + topElement);
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    System.out.println("Stack elements:");
                    st.display();
                    break;

                case 5:
                    System.out.println("Exiting the program.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            System.out.println();
        } while (ch != 5);

        sc.close();
    }
}
