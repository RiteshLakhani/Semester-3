import java.util.Scanner;
import java.util.Stack;

public class Postfix_Evaluation
{
    public static void main(String[] args) 
    {
       Scanner sc = new Scanner(System.in);

       System.out.println("Enter Postfix Expression: ");
       String exp = sc.nextLine();

       System.out.println("Postfix Evaluation: "+evaluatePostfix(exp));
    }    

    static int evaluatePostfix(String exp)
    {
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<exp.length(); i++)
        {
            char c = exp.charAt(i);

            if(Character.isDigit(c))
            {
                stack.push(Integer.parseInt(String.valueOf(c)));
            }
            else
            {
                int val1 = stack.pop();
                int val2 = stack.pop();

                if(c == '+') 
                {
                    int ans = val2 + val1;
                    stack.push(ans);
                }

                else if (c == '-') 
                {
                    int ans = val2 - val1;
                    stack.push(ans);
                }

                else if (c == '*') 
                {
                    int ans = val2 * val1;
                    stack.push(ans);
                }

                else if (c == '/') 
                {
                    int ans = val2 / val1;
                    stack.push(ans);
                }

                else if(c == '^')
                {
                    double ans = Math.pow(val2, val1);
                    stack.push((int)ans);
                }   
            }
        }
        return stack.pop();
    }
}
