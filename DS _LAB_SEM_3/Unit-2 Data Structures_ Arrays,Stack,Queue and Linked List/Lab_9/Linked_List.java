import java.util.Scanner;
import java.util.ArrayList; // Add this import statement

class LinkedList
{
    Node head;

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

    public LinkedList()
    {
        this.head = null;
    }

    // Method to insert a node at the front of the linked list
    public void insertFront(int data)
    {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
         System.out.println("Node with data " + data + " inserted at the front.");
    }

   // Method to insert a node at the end of the linked list
    public void insertEnd(int data) 
    {
        Node newNode = new Node(data);
        if (head == null) 
        {
            head = newNode;
        } 
        else 
        {
            Node current = head;
            while (current.next != null) 
            {
                current = current.next;
            }
            current.next = newNode;
        }
        System.out.println("Node with data " + data + " inserted at the end.");
    }

    // Method to delete the first node of the linked list
    public void deleteFirst()
    {
        if(head == null)
        {
            System.out.println("Linked list is empty. Cannot delete.");
            return;
        }
        
        Node firstNode = head;
        head = head.next;
        firstNode.next = null;
        System.out.println("First node with data " + firstNode.data + " deleted.");
    }

    // Method to delete the last node of the linked list
    public void deleteLast() 
    {
        if (head == null) 
        {
            System.out.println("Linked list is empty. Cannot delete.");
            return;
        }
        
        if(head.next==null)
        {
            // If there is only one node, delete it
            Node lastNode = head;
            head = null;
            System.out.println("Last node with data " + lastNode.data + " deleted.");
            return;
        }

        Node current = head;
        Node prev = null;
        while (current.next != null) 
        {
            prev = current;
            current = current.next;
        
        }

        prev.next = null;
        System.out.println("Last node with data " + current.data + " deleted.");
    }

    // Method to delete a node from a specified position in the linked list
    public void deleteAtPosition(int position) 
    {
        if (head == null) 
        {
            System.out.println("Linked list is empty. Cannot delete.");
            return;
        }

        if (position == 1) 
        {
            Node deletedNode = head;
            head = head.next;
            deletedNode.next = null;
            System.out.println("Node with data " + deletedNode.data + " deleted from position " + position + ".");
            return;
        }

        int currentPosition = 1;
        Node current = head;
        Node prev = null;

        while (current != null && currentPosition < position) 
        {
            prev = current;
            current = current.next;
            currentPosition++;
        }

        if (current == null) 
        {
            System.out.println("Position exceeds the size of the linked list. Node not found.");
            return;
        }

        prev.next = current.next;
        current.next = null;
        System.out.println("Node with data " + current.data + " deleted from position " + position + ".");
    }


    public void insertInorder(int data) 
    {
         Node newNode = new Node(data);

        if (head == null || head.data >= data) 
        {
        // If the list is empty or the new node should be inserted at the front
        newNode.next = head;
        head = newNode;
        System.out.println("Node with data " + data + " inserted in ascending order.");
        return;
    }

    Node current = head;
    while (current.next != null && current.next.data < data) 
    {
        current = current.next;
    }

    newNode.next = current.next;
    current.next = newNode;
    System.out.println("Node with data " + data + " inserted in ascending order.");
}


    // Method to display the linked list
    public void displayList() 
    {
        Node current = head;
        System.out.print("Linked List (Normal Order): ");
        while (current != null) 
        {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");

        System.out.print("Linked List (Reverse Order): ");
        printReverse(head);
        System.out.println("null");
}

    // Method to print the linked list in reverse order
    private void printReverse(Node current) 
    {
        if (current == null) {
            return;
        }
        printReverse(current.next);
        System.out.print(current.data + " -> ");
    }

    // ... (rest of your LinkedList class)

    public boolean isPalindrom() {
        // Convert the linked list to an array
        ArrayList<Integer> listArray = new ArrayList<>();
        Node current = head;
        while (current != null) {
            listArray.add(current.data);
            current = current.next;
        }

        // Check if the array is a palindrome
        int left = 0;
        int right = listArray.size() - 1;
        while (left < right) {
            if (!listArray.get(left).equals(listArray.get(right))) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

// ... (rest of your Linked_List class)

}

public class Linked_List 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        LinkedList li = new LinkedList();
        int ch;

        while(true){
            System.out.println("\nMenu:");
            System.out.println("1. Insert node at the front");
            System.out.println("2. Insert node at the end");
            System.out.println("3. Delete first node");
            System.out.println("4. Delete last node");
            System.out.println("5. Delete node at position");
            System.out.println("6. Display the linked list");
            System.out.println("7 for checking palindrom or not");
            System.out.println("8. Insert in Order:-");
            System.out.println("9 for existing to the program:");

            System.out.print("Enter your choice: ");
            ch = sc.nextInt();

            switch (ch) 
            {
                case 1:
                    System.out.print("Enter the data for the new node: ");
                    li.insertFront(sc.nextInt());
                    break;
                case 2:
                    System.out.print("Enter the data for the new node: ");
                    li.insertEnd(sc.nextInt());
                    break;
                case 3:
                    li.deleteFirst();
                    break;
                case 4:
                    li.deleteLast();
                    break;
                case 5:
                    System.out.print("Enter the position of the node to delete: ");
                    int position = sc.nextInt();
                    li.deleteAtPosition(position);
                    break;
                case 6:
                    li.displayList();
                    break;
                case 7:
                    li.isPalindrom();
                    break;
                case 8:
                    System.out.print("Enter the data for the new node: ");
                    li.insertInorder(sc.nextInt());
                    break;
                case 9: 
                        System.out.println("Existing to the Program...");
                        System.exit(0);
            }
        }
    }    
}
