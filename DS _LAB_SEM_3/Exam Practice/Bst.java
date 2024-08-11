import java.util.Scanner;

class Node
{
    int data;
    Node left;
    Node right;

    Node(int data)
    {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class Binarysearchtree
{
    static Node root;
    
    public void insert(int x)
    {
        Node current = root;
        Node prev = current;
        Node n = new Node(x);

        if(root == null)
        {
            root = n;
            return;
        }

        while(current!=null)
        {
            if(n.data < current.data)
            {
                prev = current;
                current = current.left;
            }
            else
            {
                prev = current;
                current = current.right;
            }
        }

        if(n.data < prev.data)
        {
            prev.left =n;
        }
        else
        {
            prev.right=n;
        }
    }

    public void search(int x)
    {   
        Node current = root;

        while(current!=null)
        {
            if(x==current.data)
            {
                System.out.println("Node "+ x +" is found in tree");
                return;
            }
            else if(x < current.data)
            {
                current = current.left;
            }
            else
            {
                current = current.right;
            }
        }
        System.out.println("Node "+ x +" is not found in Tree");
    }

    public void delete(int x)
    {
        Node parent = root;
        Node current = root;

        // Search for the node to delete and keep track of its parent.
        while(current!=null && current.data != x)
        {
            parent = current;

            if(current.data < x)
            {
                current = current.right;
            }
            else
            {
                current = current.left;
            }
        }

        //Root Node does not delete empty tree condition
        if(current==null)
        {
            System.out.println("Node Not Found");
            return;
        }

        //Case1: Deleting a Leaf Node;
        if(current.left==null && current.right==null)
        {
            if(parent == null) 
            {
                root = null;
            }
            else if(current == parent.left)
            {
                parent.left = null;
            }
            else
            {
                parent.right = null;
            }
        }
        //Case 2: Deleting a Node With One Child
        else if(current.left == null)
        {
            if(parent == null)
            {
                root = current.right;
            }
            else if(current == parent.left)
            {
                parent.left = current.right;
            }
            else
            {
                parent.right = current.left;
            }
        }
        else if(current.right == null)
        {
            if(parent == null)
            {
                root = current.left;
            }
            else if(current == parent.left)
            {
                parent.left = current.left;
            }
            else
            {
                parent.right = current.left;
            }
        }
        //case 3: Deleting a Node With Two Children
        else
        {
            Node successorParent = current;
            Node successor = current.right;

            while (successor.left != null) {
                successorParent = successor;
                successor = successor.left;
            }

            if (successorParent != current) {
                successorParent.left = successor.right;
            } else {
                successorParent.right = successor.right;
            }

            current.data = successor.data;
        }

        current = null;
    }

    public static void preOrder(Node root) 
    {
        if (root == null) 
        {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);

    }

    public static void inOrder(Node root) 
    {
        if (root == null) 
        {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);

    }

    public static void postOrder(Node root) 
    {
        if (root == null) 
        {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }
}

public class Bst 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        Binarysearchtree t1 = new Binarysearchtree();
        int ch;

        do{
            System.out.println("Binary Search Tree Menu: ");
            System.out.println("Enter 1 for insert a Node Into Tree:");
            System.out.println("Enter 2 for Search a Node Into Tree:");
            System.out.println("Enter 3 for delete a Node Into Tree:");
            System.out.println("Enter 4 for PreOrder:");
            System.out.println("Enter 5 for Inorder:");
            System.out.println("Enter 6 for PostOrder:");
            System.out.println("Enter 7 For Exit to Program");
            System.out.println();

            System.out.print("Enter Your Choice:");
            ch = sc.nextInt();

            switch (ch) 
            {
                case 1:
                    System.out.print("Enter value to insert: ");
                    int value = sc.nextInt();
                    t1.insert(value);
                    System.out.println("Node inserted.");
                    System.out.println();
                    break;
                case 2:
                    System.out.print("Enter value to search: ");
                    value = sc.nextInt();
                    t1.search(value);
                    System.out.println();
                    break;
                case 3:
                    System.out.print("Enter value to delete: ");
                    value = sc.nextInt();
                    t1.delete(value);
                    break;
                case 4:
                    t1.preOrder(t1.root);
                    break;
                case 5:
                    t1.inOrder(t1.root);
                    break;
                case 6: 
                    t1.postOrder(t1.root);
                    break;
                case 7:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }while(ch!=7);
    }
}