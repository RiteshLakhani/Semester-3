import java.util.Scanner;

class QueueNode {
    QueueNode next;
    int data;

    public QueueNode(int data) {
        this.data = data;
        this.next = null;
    }

    public int getData() {
        return data;
    }
}

class QueueLinkedList {
    QueueNode front, rear;

    public void insertRear(int x) {
        QueueNode newNode = new QueueNode(x);

        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    public int deleteFront() {
        if (front == null) {
            System.out.println("Underflow");
            return -1;
        }

        int data = front.getData();
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return data;
    }

    public void display() {
        QueueNode current = front;
        System.out.print("Queue: ");
        while (current != null) {
            System.out.print(current.getData() + " ");
            current = current.next;
        }
        System.out.println();
    }
}

public class Queue_Linked {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        QueueLinkedList queue = new QueueLinkedList();

        while (true) {
            System.out.println("Enter 1 for Enqueue (Push):");
            System.out.println("Enter 2 for Dequeue (Pop):");
            System.out.println("Enter 3 for Display:");
            System.out.println("Enter 4 to Exit");

            System.out.println("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter Element: ");
                    int x = sc.nextInt();
                    queue.insertRear(x);
                    break;

                case 2:
                    int removedElement = queue.deleteFront();
                    if (removedElement != -1) {
                        System.out.println("Removed Element: " + removedElement);
                    }
                    break;

                case 3:
                    queue.display();
                    break;

                case 4:
                    System.exit(0);

                default:
                    System.out.println("Enter a valid number...");
            }
            System.out.println("----------------------------------------------------------------");
        }
    }
}
