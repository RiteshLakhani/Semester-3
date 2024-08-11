import java.util.Scanner;

class Node
{
    int data;
    Node next;

    public Node(int data)
    {
        this.data = data;
        this.next = null;
    }
}

public class node_Create
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        
        Node head = null;
        Node tail = null;

        System.out.print("Enter The Number Of The Nodes:");
        int n = sc.nextInt();

        for(int i=0;i<n;i++)
        {
            System.out.println("Enter value for node "+(i+1)+": ");
            int val = sc.nextInt();

            Node newNode = new Node(val);

            if(head == null)
            {
                head = newNode;
                tail = newNode;
            }
            else
            {
                tail.next = newNode;
                tail = newNode;
            }
        }

        System.out.println("Linked List Elements: ");
        Node current = head;
        while(current!=null)
        {
            System.out.print(current.data+" ");
            current = current.next;
        }
    
        sc.close();
    }    
}
