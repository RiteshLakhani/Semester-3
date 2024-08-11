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

public class node_singly_list 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter data for the node: ");
        int data = sc.nextInt();

        Node node = new Node(data);
        System.out.println("Node data: " + node.data);

        sc.close();
    }
}
