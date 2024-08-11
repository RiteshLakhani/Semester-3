import java.util.Scanner;
import java.util.Stack;

public class infix_post_pre {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Infix String:-");
        String infix = sc.nextLine();

        System.out.println("Postfix:- " + toPostfix(infix));
        System.out.println("Prefix:- " + toPostfix(infix));
    }

    public static String toPostfix(String infix) {
        infix = "(" + infix + ")" + " ";
        Stack<Character> st = new Stack<>();
        int i = 0;

        st.push('(');

        char next;
        String POLISH = " ";
        int rank = 0;

        next = infix.charAt(i);
        i++;

        while (next != ' ') {
            while (stackPre(st.peek()) > inputPre(next)) {
                char temp = st.pop();
                POLISH += temp;
                rank += calculateRank(temp);

                if (rank < 1) {
                    System.out.println("Invalid");
                    System.exit(0);
                }
            }

            if (stackPre(st.peek()) != inputPre(next)) {
                st.push(next);
            } else {
                st.pop();
            }

            next = infix.charAt(i);
            i++;
        }

        if (rank != 1) {
            System.out.println("Invalid");
            System.exit(0);
            return "";
        } else {
            System.out.println("Valid");
            return POLISH;
        }
    }

    public static int calculateRank(char ch) {
        if (Character.isLetter(ch)) {
            return 1;
        } else {
            return -1;
        }
    }

    public static int inputPre(char ch) {
        if (ch == '+' || ch == '-') {
            return 1;
        } else if (ch == '*' || ch == '/') {
            return 3;
        } else if (ch == '^' || ch == '$') {
            return 6;
        } else if (Character.isLetter(ch)) {
            return 7;
        } else if (ch == '(') {
            return 9;
        } else if (ch == ')') {
            return 0;
        } else {
            System.out.println("Invalid");
            System.exit(0);
            return -1;
        }
    }

    public static int stackPre(char ch) {
        if (ch == '+' || ch == '-') {
            return 2;
        } else if (ch == '*' || ch == '/') {
            return 4;
        } else if (ch == '^' || ch == '$') {
            return 5;
        } else if (Character.isLetter(ch)) {
            return 8;
        } else if (ch == '(') {
            return 0;
        } else {
            System.out.println("Invalid character in infix expression.");
            System.exit(0);
            return -1;
        }
    }

    public static String toPrefix(String infix)
    {
        String reversed = ""; 
        String prefix="";

        for(int i=infix.length()-1 ; i>=0;i--)
        {
            if(infix.charAt(i)=='(')
            {
                reversed = reversed + ')';
            }
            else if(infix.charAt(i)==')')
            {
                reversed = reversed + '(';
            }
            else
            {
                reversed = reversed + infix.charAt(i); 
            }
        }

        String polish = toPostfix(reversed);

        for(int i=polish.length()-1;i>=0;i--)
        {
            prefix = prefix + polish.charAt(i);
        }   
        
        return prefix;
    }
}