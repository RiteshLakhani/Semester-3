import java.util.Scanner;

class LinkedListMethod {
    static Node n;

    static class Node {
        int no;
        Node next;

        Node(int a) {
            this.no = a;
            this.next = null;
        }
    }

    public void insert(int var) {
        Node node = new Node(var);

        if (n == null) {
            n = node;
        } else {
            Node temp = n;

            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
    }

    public void displayAll() {
        Node current = n;

        if (n == null) {
            System.out.println("List is empty");
            return;
        }

        while (current != null) {
            System.out.print(current.no + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void sort() {
        Node current = n;
        Node sortNode;
        int temp;

        if (n == null) {
            System.out.println("List Is Empty");
        } else {
            while (current.next != null) {
                sortNode = current.next;

                while (sortNode != null) {
                    if (current.no > sortNode.no) {
                        temp = current.no;
                        current.no = sortNode.no;
                        sortNode.no = temp;
                    }
                    sortNode = sortNode.next;
                }
                current = current.next;
            }
        }
    }
}

public class LinkedListImp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LinkedListMethod li = new LinkedListMethod();

        while (true) {
            System.out.println("Enter 0 to Exit:");
            System.out.println("Enter 1 to Insert:");
            System.out.println("Enter 2 to Display:");
            System.out.println("Enter 3 to Sort the LinkedList:");
            System.out.println("Enter your choice: ");
            int c = sc.nextInt();

            switch (c) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    System.out.println("Enter Number to Insert");
                    li.insert(sc.nextInt());
                    break;
                case 2:
                    li.displayAll();
                    break;
                case 3:
                    li.sort();
                    break;
                default:
                    System.out.println("Enter a valid input.");
            }
            System.out.println();
            System.out.println();
        }
    }
}
