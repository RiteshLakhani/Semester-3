import java.util.Scanner;

class ManiStack
{
	int top,size;
	String [] stack;

	ManiStack(int size)
	{
		stack = new String[size];
		this.size = size;
		top=-1;
	}

	public void push(String n)
	{
		if(top==size-1)
		{
			System.out.println("Stack OverFlow");
		}
		else
		{
			top++;
			stack[top] = n;
			System.out.println("Pushed "+ n +" on to the Stack");
		}
	}

	public String pop()
	{
		if(top<=-1)
		{
			System.out.println("Stack UnderFlow");
			return "";
		}
		else
		{
			System.out.println(stack[top]+" has been Poppe");
			return stack[top--];
		}
	}
}

public class ReverseString_Practice
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter String: ");
		String a = sc.nextLine();

		String b = reverseString(a);

		System.out.println("Original String: "+a);
		System.out.println("Reversed String: "+b);	
	}

	public static String reverseString(String a)
	{
		int length = a.length();

		ManiStack si = new ManiStack(length);

		for(int i=0;i<length;i++)
		{
			si.push(String.valueOf(a.charAt(i)));
		}

		char [] reverseChar = new char[length];

		for(int i=0;i<length;i++)
		{
			reverseChar[i] = si.pop().charAt(0); 
		}
		return new String(reverseChar);
	}
}