import java.util.Scanner;

class Queue 
{
    static Node front;
    static Node rear;
    private int maxSize;
    private int count;

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

    public Queue(int maxSize) 
    {
        this.maxSize = maxSize;
        this.count = 0;
        front = null;
        rear = null;
    }

    public boolean isEmpty() 
    {
        return front == null;
    }

    public boolean isFull() 
    {
        return count == maxSize;
    }

    public void enqueue(int data) 
    {
        if (isFull())
        {
            throw new IllegalStateException("Queue is full. Cannot enqueue.");
        }

        Node newNode = new Node(data);

        if (isEmpty()) 
        {
            front = newNode;
            rear = newNode;
        }
        else 
        {
            rear.next = newNode;
            rear = newNode;
        }
        count++;
    }

    public int dequeue() 
    {
        if (isEmpty()) 
        {
            throw new IllegalStateException("Queue is empty. Cannot dequeue.");
        }
            int data = front.data;
            front = front.next;
            count--;
            return data;
    }

    public int peek() 
    {
        if (isEmpty()) 
        {
            throw new IllegalStateException("Queue is empty. Cannot peek.");
        }
        return front.data;
    }

    public void display() 
    {
        if (isEmpty()) 
        {
            throw new IllegalStateException("Queue is empty.");
        }

        Node current = front;
        while (current != null) 
        {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

public class queue_by_linkedlist
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the maximum size of the queue: ");
        int maxSize = sc.nextInt();
        Queue queue = new Queue(maxSize);

        int ch;

        do {
            System.out.println("Menu:");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            ch = sc.nextInt();

            switch (ch) 
            {
                case 1:
                        if (queue.isFull())
                        {
                            System.out.println("Queue is full. Cannot enqueue.");
                        } 
                        else 
                        {
                            System.out.print("Enter the element to enqueue: ");
                            int data = sc.nextInt();
                            queue.enqueue(data);
                        }
                    break;

                case 2:
                        try 
                        {
                            int dequeuedElement = queue.dequeue();
                            System.out.println("Dequeued element: " + dequeuedElement);
                        }catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                        }
                    break;

                case 3:
                        try 
                        {
                            int frontElement = queue.peek();
                            System.out.println("Front element: " + frontElement);
                        }catch (IllegalStateException e) {
                            System.out.println(e.getMessage());
                        }
                    break;

                case 4:
                    System.out.println("Queue elements:");
                    queue.display();
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
