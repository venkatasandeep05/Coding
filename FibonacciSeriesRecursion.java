// Fibonacci series generation using recursion  -- O(n2)

import java.util.Scanner;
public class FibonacciSeriesRecursion
{
	public static void main(String[] args)
	{
	    int n;
	    Scanner sc=new Scanner(System.in);
	    n=sc.nextInt();
		for(int i=0;i<n;i++)
		{
		    System.out.println(fibonacci(i));
		}
	}
	
 public static int fibonacci(int n)
{
    if(n==0)
    return 0;
    else if(n==1)
    return 1;
    else
    return fibonacci(n-1)+fibonacci(n-2);
}

}
