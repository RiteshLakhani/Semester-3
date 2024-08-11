import java.util.*;

class StackMain {
    int top, size;
    String[] stack;

    StackMain(int size) {
        stack = new String[size];
        this.size = size;
        top = -1;
    }

    public void push(String n) {
        if (top == size - 1) {
            System.out.println("Stack Overflow.");
        } else {
            top++;
            stack[top] = n;
            System.out.println("Pushed " + n + " onto the stack.");
        }
    }

    public String pop() {
        if (top <= -1) {
            System.out.println("Stack Underflow.");
            return " ";
        } else {
            System.out.println(stack[top] + " has been popped");
            return stack[top--];
        }
    }

    public String peek() {
        if (top <= -1) {
            System.out.println("Stack Underflow.");
            return "";
        } else {
            return stack[top];
        }
    }
}

class Recognize {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter String : ");
        String str = input.nextLine();

        StackMain st = new StackMain(str.length() + 1);
        System.out.println();

        int i = 1;
        String next;
        st.push("c");
        next = i < str.length() ? Character.toString(str.charAt(0)) : "c";

        while (!next.equals("c")) {
            if (next.equals(" ")) {
                System.out.println("Invalid String");
                System.exit(0);
            } else {
                st.push(next);
                if (i < str.length()) {
                    next = Character.toString(str.charAt(i));
                } else {
                    next = "c"; // If the end of the input string is reached
                }
                i++;
            }
        }

        while (!st.peek().equals("c")) {
            if (i < str.length()) {
                next = Character.toString(str.charAt(i));
            } else {
                next = "c"; // If the end of the input string is reached
            }
            i++;

            String x = st.pop();

            if (!next.equals(x)) {
                System.out.println("Invalid String");
                System.exit(0);
            }
        }

        if (next.equals("c") || next.equals(" ")) {
            System.out.println("Valid String");
        } else {
            System.out.println("Invalid String");
        }
    }
}
