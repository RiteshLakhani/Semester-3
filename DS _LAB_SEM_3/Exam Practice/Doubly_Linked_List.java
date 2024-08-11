import java.util.Scanner;

class Node
{
    Node lptr;
    Node rptr;
    int data;

    public Node(int data)
    {
        this.data = data;
        this.lptr = null;
        this.rptr = null;
    }
}

class DDL
{
    Node left;
    Node right;
    int size=0;

    public void insertLeft(int n)
    {
        Node newN = new Node(n);

        if(right == null)
        {
            left = right = newN;
        }
        else
        {
            left.lptr = newN;
            newN.rptr = left;
            left = newN;
        }
        size++;
    }

    public void insertRight(int x)
    {
        Node newN = new Node(x);

        if(right == null)
        {
            left = right = newN;
        }
        else
        {
            right.rptr = newN;
            newN.lptr = right;
            right = newN;
        }
        size++;
    }

    public void inserMiddle(int m)
    {
        Node newN = new Node(m);

        if(right == null)
        {   
            left = right = newN;
        }
        else
        {
            int middle = size/2;
            Node current = left;
            int currentPostion = 0;

            while(currentPostion < middle)
            {
                current = current.rptr;
                currentPostion++;
            }

            newN.rptr = current;
            newN.lptr = current.lptr;
            current.lptr.rptr = newN;
            current.lptr = newN;

            if(currentPostion==size-1)
            {
                right = newN;
            }
            size++;
        }
    }

    public void display()
    {
        if(right==null)
        {
            System.out.println("Cant dispaly List Is Empty...");
        }
            Node save = left;

            do{
                System.out.print(save.data+" ");
                save = save.rptr;
            }while(save!=null);
            System.out.println(" ");
    }


    public int delLeft()
    {
        if(right==null)
        {
            System.out.println("Cant delete because List Is Empty");
            return 0;
        }

        int dataDeleteLeft = left.data;

        if(left==right)
        {
            left = right = null;
        }
        else
        {
            left = left.rptr;
            left.lptr = null;
        }
        size--;
        return dataDeleteLeft;
    }

    public int delRight()
    {
        if(right == null)
        {
            System.out.println("Cant delete because List Is Empty");
            return 0;
        }
        
        int dataDeleteRight = right.data;

        if(left==right)
        {
            left = right = null;
        }
        else
        {
            right = right.lptr;
            right.rptr = null;
        }
        size--;
        return dataDeleteRight;
    }

    public Node deletePostion(int postion)
    {
        Node temp = left;
        int count = 1 ;

        if(postion>size || postion<1)
        {
            System.out.println("Node Not Available");
            return null;
        }

        if(postion==1)
        {
            left = left.rptr;
            if(left!=null)
            {
                left.lptr = null;
            }
            size--;
            return temp;
        }

        while(temp!=null)
        {
            if(count == postion)
            {
                Node l = temp.lptr;
                Node r = temp.rptr;


                if(r!=null)
                {
                    l.rptr.lptr = temp.lptr;
                }
                else
                {
                    right = temp.lptr;
                }

                temp.lptr = temp.rptr = null;
                size--;
                return temp;
            }
        }
        return null;
    }
}
public class Doubly_Linked_List 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        DDL li = new DDL();
        
        while(true) 
        {
            System.out.println(" 1 for Insert Left:-");
            System.out.println(" 2 for Insert Right:-");
            System.out.println(" 3 for Insert Middle:-");
            System.out.println(" 4 for Display:-");
            System.out.println(" 5 for Delete from Left Side:-");
            System.out.println(" 6 for Delete From Right Side:-");
            System.out.println(" 7 for Exist:-");
            

            System.out.println("Enter Your Choice:-");
            int ch = sc.nextInt();

            switch(ch)
            {
                case 1:
                        System.out.println("Enter Left Most Side Element:-");
                        int n = sc.nextInt();
                        li.insertLeft(n);
                        break;
                case 2:
                        System.out.println("Enter Right Most Side Element:-");
                        int x = sc.nextInt();
                        li.insertRight(x);
                        break;
                
                case 3:
                        System.out.println("Enter Middle Element:-");
                        int m = sc.nextInt();
                        li.inserMiddle(m);
                        break;
                
                case 4:
                        li.display();
                        break;

                case 5:
                        li.delLeft();
                        break;
                    
                case 6:
                        li.delRight();
                        break;
                    
                case 7:
                        System.exit(0);
                        break;

                default:
                        System.out.println("Enter Valid Number For each Operation...");
            }
            System.out.println("----------------------------------------------------------------");
        }
    }
}
