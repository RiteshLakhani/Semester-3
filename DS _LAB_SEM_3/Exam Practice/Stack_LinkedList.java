import java.util.Scanner;

class Stack
{
    int data;
    Stack next;

    public  Stack(int data)
    {
        this.data = data;
        this.next = null;
    }
}

class StackLinkedList
{
    Stack top;  

    public void push(int x)
    {
        Stack newN = new Stack(x);
        newN.next = top;
        top = newN;
    }

    public int pop()
    {
        if(top==null)
        {
            System.out.println("Stack empty");
            return -1;
        }
        int data = top.data;
        top = top.next;
        return data;
    }

      public void display() 
      {
        Stack current = top;
        System.out.print("Stack: ");
        while (current != null) 
        {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

public class Stack_LinkedList
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        
        StackLinkedList si = new StackLinkedList();

        while(true)
        {
            System.out.println("Enter 1 for Push:-");
            System.out.println("Enter 2 for Pop:-");
            System.out.println("Enter 3 for Display:-");

            System.out.println("Enter your choice:- ");
            int ch = sc.nextInt();

            switch(ch)
            {
                case 1:
                    System.out.println("Enter Element:- ");
                    int x = sc.nextInt();
                    si.push(x);
                    break;
                
                case 2:
                        si.pop();
                        break;
                
                case 3:
                        si.display();
                        break;
                default:
                    System.out.println("Entr valid Number...");
            }
            System.out.println("----------------------------------------------------------------");
        }


    }
}
