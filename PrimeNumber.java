// Prime Number or not 

import java.util.Scanner;
public class PrimeNumber
{
	public static void main(String[] args)
	{
	    int n,flag=0;
	    Scanner sc=new Scanner(System.in);
	    n=sc.nextInt();
		for(int i=2;i<=n/2;i++)
		{
		    if(n%i==0)
		    {
		        flag=1;
		        System.out.println("Not a Prime Number");
		        break;
		    }
		}
		if(flag==0)
		System.out.println("Prime Number");
	}
}
