import java.util.Scanner;

class Node {
    Node lptr;
    int value;
    Node rptr;

    public Node(int value) {
        this.lptr = null;
        this.rptr = null;
        this.value = value;
    }
}

class DouLinkedList {
    Node start;
    Node end;
    int size = 0;

    public void insrt_first(int x) {
        Node newN = new Node(x);

        if (start == null) {
            start = end = newN;
        } else {
            start.lptr = newN;
            newN.rptr = start;
            start = newN;
        }
        size++;
    }

    public void insert_end(int x) {
        Node newN = new Node(x);

        if (start == null) {
            start = end = newN;
        } else {
            end.rptr = newN;
            newN.lptr = end;
            end = newN;
        }
        size++;
    }

    public Node deletePostion(int position) {
        Node temp = start;
        int count = 1;

        if (position > size || position < 1) {
            System.out.println("Node Not Available");
            return null;
        }

        if (position == 1) {
            start = start.rptr;
            if (start != null) {
                start.lptr = null;
            }
            size--;
            return temp;
        }

        while (temp != null) {

            if (count == position) {
                Node L = temp.lptr;
                Node R = temp.rptr;

                L.rptr = R;
                if (R != null) {
                    R.lptr = L;
                } else {
                    end = L; // Update the end node if the last node is deleted
                }

                temp.lptr = temp.rptr = null;
                // temp.lptr.rptr = temp.rptr;
                // temp.rptr.lptr = temp.lptr;
                // temp.lptr = temp.rptr = null;

                size--;

                return temp;
            }

            temp = temp.rptr;
            count++;
        }
        return null;
    }

    public void display() {

        if (start == null) {
            System.out.println("Empty");
            return;
        }

        Node save = start;

        do {
            System.out.print(save.value + " ");
            save = save.rptr;
        } while (save != null);
    }

}

public class DoublyLinked_list {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        DouLinkedList dl = new DouLinkedList();

        int ch;

        do {
            System.out.println("Enter 1 for Add at Front in Doubly Linked List");
            System.out.println("Enter 2 for Insert at End in Doubly Linked List");
            System.out.println("Enter 3 for Display");
            System.out.println("Enter 4 for Delete Node from Specified Position");
            System.out.println("Enter 5 for Exit");

            System.out.print("Enter your choice: ");
            ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.println("Enter data to add at the front: ");
                    dl.insrt_first(sc.nextInt());
                    break;
                case 2:
                    System.out.println("Enter data to insert at the end: ");
                    dl.insert_end(sc.nextInt());
                    break;
                case 3:
                    System.out.print("Display Doubly Linked List-->");
                    dl.display();
                    System.out.println();
                    break;
                case 4:
                    System.out.println("Enter Position to delete: ");
                    int position = sc.nextInt();
                    dl.deletePostion(position);
                    break;
                case 5:
                    System.exit(0);

                default:
                    System.out.println("Plz Enter Valid Number....");
            }
        } while (ch != 5);

    }
}
