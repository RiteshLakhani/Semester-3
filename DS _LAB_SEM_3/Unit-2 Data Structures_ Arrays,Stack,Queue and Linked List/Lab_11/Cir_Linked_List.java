import java.util.Scanner;

class LinkedList
{
    static Node head;
    static Node last;

    static class Node
    {
        int data;
        Node next;

        public Node(int data)
        {
            this.data = data;
            this.next = null;
        }
    }

    public void addFront(int data)
    {
        Node newNode = new Node(data);

        if(head==null)
        {
            newNode.next = newNode;
            head = newNode;
            last = newNode;
        }
        else
        {
            newNode.next = head;
            last.next = newNode;
            head = newNode;
        }
    }

    public void insertEnd(int data)
    {
        Node newNode = new Node(data);

        if (head == null) 
        {
            newNode.next = newNode;
            head = newNode;
            last = newNode;
        } 
        else 
        {
            newNode.next = head;
            last.next = newNode;
            last = newNode;
        }
    }

    public void display()
    {
        if(head==null)
        {
            System.out.println("Empty");
            return;
        }

        Node save = head; 
        
        do
        {
            System.out.print(save.data + " ");
            save = save.next;
        }while (save != head);

        System.out.println();
    }

    public void deleteAtPosition(int position) 
    {
        if (head == null) 
        {
            System.out.println("Empty");
            return;
        }

        // IF AND OLNY IF ONE NODE IN LINKED LIST THEN FLOW BELOW CODE
        if (position == 1) 
        {
            if (head == last) 
            {
                head = null;
                last = null;
            } 
            else 
            {
                Node deleteNode = head;
                last.next = head.next;
                head = head.next;
            }
        return;
        }

        Node current = head;
        Node pred = head;
        int count = 1;

        while(count < position && current.next != head)
        {
            pred = current;
            current = current.next;
            count++;
        }

        if(count < position)
        {
            System.out.println("Position Out of Bound");
            return;
        }

        pred.next = current.next;

        if (current == last) 
        {
            last = pred;
        }
    }
}

public class Cir_Linked_List
{ 
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        LinkedList li = new LinkedList();

        int ch;

        do
        {
            System.out.println("Enter 1 for Add at Front");
            System.out.println("Enter 2 for Insert at End");
            System.out.println("Enter 3 for Display");
            System.out.println("Enter 4 for Delete Node from Specified Position");
            System.out.println("Enter 5 for Exit");

            System.out.print("Enter your choice: ");
            ch = sc.nextInt();


            switch(ch)
            {
                case 1:
                        System.out.println("Enter data to add at the front: ");
                        li.addFront(sc.nextInt());
                        break;
                case 2:
                        System.out.println("Enter data to insert at the end: ");
                        li.insertEnd(sc.nextInt());
                        break;
                case 3:
                        System.out.print("Display Circular Linked List-->");
                        li.display();
                        break;
                case 4:
                        System.out.println("Enter Position to delete: ");
                        int position = sc.nextInt();
                        li.deleteAtPosition(position);
                        break;
                case 5:
                        System.exit(0);
                
                default:
                        System.out.println("Plz Enter Valid Number....");
            }
        }while(ch!=5);
    }
} 


