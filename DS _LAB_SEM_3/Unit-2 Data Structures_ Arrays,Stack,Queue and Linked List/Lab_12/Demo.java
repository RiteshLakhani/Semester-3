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

class Dlll
{
    Node start;
    Node end;
    int size;

    public void insertLeft(int x)
    {
        Node newN = new Node(x);

        if(start==null)
        {
            start=end=newN;
        }
        else
        {
            start.lptr = newN;
            newN.rptr = start;
            start = newN;
        }
        size++;
    }

    public void insertRight(int x)
    {
         Node newN = new Node(x);

        if(start==null)
        {
            start=end=newN;
            return;
        }
        else
        {
            end.rptr = newN;
            newN.lptr = end;
            end = newN;
        }
        size++;
    }

    public void deleteLeft()
    {
        if(start==null)
        {
            System.out.println("List Is Empty");
            return;
        }
        
        if(start==end)
        {
            start=null;
            end=null;
        }
        else
        {
            start = start.rptr;
            start.lptr = null;
        }
        size--;
    }

    public void deleteRight()
    {
        if(end==null)
        {
            System.out.println("List Is Empty");
            return;
        }
        
        if(start==end)
        {
            start=null;
            end=null;
            return;
        }
        else
        {
            end = end.lptr;
            end.rptr = null;
        }
        size--;
    }

    public void display()
    {
        if(start == null)
        {
            System.out.println("Cant be Display");
            return;
        }

        Node save = start;

        do{
            System.out.print(save.data+" ");
            save = save.rptr;
        }while(save!=null);
    }

    public void insert_middle(int x)
    {
        Node newN = new Node(x);

        if(start==null)
        {
            start=end=newN;
        }
        else
        {
            int middle = size/2;
            Node current = start;
            int currentPostion = 0;
            
            while(currentPostion<middle)
            {
                current = current.rptr;
                currentPostion++;
            }

            newN.rptr = current;
            newN.lptr = current.lptr;
            if(current.lptr!=null)
            {
                current.lptr.rptr = newN;
            }
            current.lptr = newN;

            if(currentPostion == size-1)
            {
                end = newN;
                return;
            }
        }
        size++;
    }

    public Node delPostion(int position)
    {
        Node temp = start;
        int count = 1; 

        if(position>size || position<1)
        {
            System.out.println("Node Not Available");
            return null;
        }

        if(position==1)
        {
            start = start.rptr;

            if(start!=null)
            {
                start.lptr=null;
            }
            size--;
            return temp;
        }

        while(temp!=null)
        {
            if(count == position)
            {
                temp.lptr.rptr = temp.rptr;

                if(temp.rptr!=null)
                {
                    temp.rptr.lptr = temp.lptr;
                }
                else
                {
                    end = temp.lptr;
                }
                    temp.lptr = temp.rptr = null;
                    size--;
                    return temp;
            }
            temp = temp.rptr;
            count++;
        }
        return null;
    }
}

public class Demo
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        Dlll li = new Dlll();

        int ch;

        do{
            System.out.println("Enter 1 for Add Into Left Side:");
            System.out.println("Enter 2 for Add Into Right Side:");
            System.out.println("Enter 3 for Delete Into Left Side:");
            System.out.println("Enter 4 for Delete Into Right Side:");
            System.out.println("Enter 5 For Display:");
            System.out.println("Enter 6 for Exit");
            System.out.println("Enter 7 for InsertInMiddle:");
            System.out.println("Enter 8 For Delete Node From specific Postion:");


            System.out.println("Enter choice:");
            ch = sc.nextInt();

            switch(ch)
            {
                case 1:
                        System.out.println("Enter Number: ");
                        int x = sc.nextInt();
                        li.insertLeft(x);
                        break;
                case 2:
                        System.out.println("Enter Number: ");
                        int y = sc.nextInt();
                        li.insertRight(y);
                        break;
                case 3:
                        li.deleteLeft();
                        break;
                case 4:
                    li.deleteRight();
                    break;
                case 5:
                    li.display();
                    break;
                case 6:
                    System.out.println("Exiting program.");
                    break;
                case 7:
                        System.out.println("Enter Number: ");
                        int z = sc.nextInt();
                        li.insert_middle(z);
                        break;
                case 8:
                        System.err.println("Enter Postion:");
                        int pos = sc.nextInt();
                        li.delPostion(pos);
                        break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }while(ch!=6);



    }
}