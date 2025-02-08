// Palindrome Number Problem : given a number find if it is palindrome or not

import java.util.Scanner;
public class PalindromeNumber
{
	public static void main(String[] args) 
	{
	    int n,reverseNumber=0,r;
	    Scanner sc=new Scanner(System.in);
	    n=sc.nextInt();
	    int temp=n;
	    while(temp>0)
	    {
	        r=temp%10;   
	        reverseNumber=reverseNumber*10+r;
	        temp=temp/10;
	    }
	    if(reverseNumber==n)
	    System.out.println("Given number is a plaindrome");
	}
}
