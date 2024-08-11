import java.util.Scanner;

class StackMain {
    int size, top;
    String[] stack;

    StackMain(int size) {
        stack = new String[size];
        this.size = size;
        top = -1;
    }

    public void push(String n) {
        if (top == size - 1) {
            System.out.println("Stack Overflow");
        } else {
            top++;
            stack[top] = n;
        }
    }

    public String pop() {
        if (top == -1) {
            System.out.println("Stack underflow");
            return " ";
        } else {
            return stack[top--];
        }
    }
}

public class Postfix_Prefix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Postfix Expression:-");
        String exp = sc.nextLine();

        System.out.println("Postfix Evaluation:" + evaluatePostfix(exp));
    }

    static String evaluatePostfix(String exp) {
        StackMain st = new StackMain(exp.length());

        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);

            if (Character.isDigit(c)) 
            {
                st.push(String.valueOf(c));
            } 
            else 
            {
                String val1 = st.pop();
                String val2 = st.pop();

                int num1 = Integer.parseInt(val1);
                int num2 = Integer.parseInt(val2);

                if (c == '+') {
                    int ans = num2 + num1;
                    st.push(String.valueOf(ans));
                } else if (c == '-') {
                    int ans = num2 - num1;
                    st.push(String.valueOf(ans));
                } else if (c == '*') {
                    int ans = num2 * num1;
                    st.push(String.valueOf(ans));
                } else if (c == '/') {
                    int ans = num2 / num1;
                    st.push(String.valueOf(ans));
                }   
            }
        }
        return st.pop();
    }
}
