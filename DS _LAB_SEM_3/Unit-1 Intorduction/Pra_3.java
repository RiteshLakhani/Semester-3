import java.util.Scanner;

public class Pra_3
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Character: ");
		char ch = sc.next().charAt(0);

		boolean isVowel = isVowel(ch);

        if (isVowel) 
        {
            System.out.println(ch + " is a vowel.");
        } 
        else 
        {
            System.out.println(ch + " is Consonent.");
        }
	}

	public static boolean isVowel(char ch)
	{
		ch = Character.toLowerCase(ch);

        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}
