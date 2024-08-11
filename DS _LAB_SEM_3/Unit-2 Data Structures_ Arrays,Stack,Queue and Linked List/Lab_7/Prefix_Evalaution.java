import java.util.Scanner;
import java.util.Stack;

public class Prefix_Evalaution
{    
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter prefix string : ");
        String exp = sc.next();

        System.out.println("prefix evaluation: " + evaluatePostfix(exp));
    }

    static int evaluatePostfix(String exp) 
    {
        Stack<Integer> stack = new Stack<>();

        for (int i = exp.length() - 1; i >= 0; i--) 
        {
            char c = exp.charAt(i);

            if (Character.isDigit(c)) 
            {
                stack.push(Integer.parseInt(String.valueOf(c)));
            }

            else 
            {
                int val1 = stack.pop();
                int val2 = stack.pop();

                if (c == '+') 
                {
                    int ans = val1 + val2;
                    stack.push(ans);
                }

                else if (c == '-') 
                {
                    int ans = val1 - val2;
                    stack.push(ans);
                }

                else if (c == '*') 
                {
                    int ans = val1 * val2;
                    stack.push(ans);
                }

                else if (c == '/') 
                {
                    int ans = val1 / val2;
                    stack.push(ans);
                }

                else if (c == '^') 
                {
                    double ans = Math.pow(val1, val2);
                    stack.push((int)ans);
                }
            }
        }
        return stack.pop();
    }
}