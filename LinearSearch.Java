// Linear search problem : given an array of size n . find the element x in the array using o(n) time complexity

import java.util.Scanner;
public class LinearSearch
{
	public static void main(String[] args) 
	{
	    int n,x;    // n is no of elements in the array
	    Scanner sc=new Scanner(System.in);
	    n=sc.nextInt();
		int arr[]=new int[n];
		for(int i=0;i<n;i++)
		{
		    arr[i]=sc.nextInt();
		}
		x=sc.nextInt();  // x is elememnt which need to be searched 
		
		for(int y:arr)
		{
		    if(y==x)
		    {
		        System.out.println("Element found in the array");
		        break;
		    }
		}
	}
}
