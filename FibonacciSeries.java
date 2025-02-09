//N number Fibonacci series generation using loops 

import java.util.Scanner;

public class FibonacciSeries
{
	public static void main(String[] args) 
	{
		int i=0,j=1,n,a;
		
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		while(n>0)
		{
		    a=i+j;
		    System.out.println(i);
		    i=j;
		    j=a;
		    n--;
		}
	}
}
