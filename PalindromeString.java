// Palindrome Problem : given a string find if it is a Palindrome or not

import java.util.Scanner;
public class PalindromeString
{
	public static void main(String[] args) 
	{
	    String str;
	    Scanner sc=new Scanner(System.in);
	    
	    str=sc.nextLine();
	    
	    StringBuffer sb=new StringBuffer(str);
	    String reverseString =new String(sb.reverse());
	    
	    if(str.equals(reverseString))
	    System.out.println("The Given String is a plaindrome");
	}
}
