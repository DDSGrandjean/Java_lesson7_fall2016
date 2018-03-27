/**
 * COMI2510 - Advanced Java Programming
 * November 14th, 2016
 * 
 * Program designed to detect whether a string is a
 * palindrom or not using recursive method.
 * 
 * @author Dylan Grandjean
 */
import javax.swing.JOptionPane;

public class PalindromeProgram 
{
	/**
	 * Recursive method which takes in a previously formatted
	 * string and examines the letters on each end, moving towards
	 * the middle, to determine whether the string is a palindrome or
	 * not.
	 * @param s - Formatted string to process.
	 * @param n - Number representing the middle of the string.
	 * @param i - Character's index
	 * @return Whether the string is palindrom or not.
	 */
	public static boolean palindromDetector(String s, int n, int i)
	{
		Boolean isPalindrom = true;
		if(i < n)
			if(s.charAt(i) == s.charAt(s.length() - (1 + i)))
				isPalindrom = palindromDetector(s, n, i + 1);
			else
				isPalindrom =  false;
		
		return isPalindrom;
	}
	
	/**
	 * Get user's input through a JOptionPane input window, formats 
	 * it to make it ready for the palindromDetector() method to process
	 * it, then display a message to inform the player of whether the
	 * sentence is palindrom or not.
	 * @param args - Array of String arguments.
	 */
	public static void main(String[] args)
	{
		//Fields:
		String cleanedUp = "";
		boolean isPalindrom;
		int mid;
		char ch;
		
		//Get user input
		String input = JOptionPane.showInputDialog(null, "Enter a sentence to process", "Welcome", JOptionPane.PLAIN_MESSAGE);
		//Clean up input (not part of the assignment)
		for(int i = 0; i < input.length(); i++)
		{
			ch = input.charAt(i);
			if(Character.isAlphabetic(ch))
				cleanedUp += Character.toLowerCase(ch);
		}
		//Ensures input is not empty
		if(cleanedUp.length() > 0)
		{
			mid = cleanedUp.length() / 2;
			isPalindrom = palindromDetector(cleanedUp, mid, 0);
		}
		else
			isPalindrom = false;
		
		//Display result to screen
		if(isPalindrom)
			JOptionPane.showMessageDialog(null, "This sentence is a palindrom!", "Palindrom ahead!", JOptionPane.INFORMATION_MESSAGE);
		else
			JOptionPane.showMessageDialog(null, "I'm sorry, but this sentence is not a palindrom.", "Bummer..", JOptionPane.ERROR_MESSAGE);
	}
}
