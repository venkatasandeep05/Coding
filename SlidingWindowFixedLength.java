// Problem: Given an array of integers, find the maximum sum of a subarray with a fixed window size=3.

import java.util.Scanner;
public class SlidingWindowFixedLength
{
	public static void main(String[] args) 
	{
	    Scanner sc=new Scanner(System.in);
	    System.out.println("Enter size of the array");
	    int n=sc.nextInt();
		int arr[]=new int[n];
		int i,j,sum=0;
		System.out.println("Enter the elements of the array");
		for(i=0;i<n;i++)
		arr[i]=sc.nextInt();
		System.out.println("Enter the size of the window");
		int windowSize=sc.nextInt();
		if(n<windowSize)
		System.out.println("Window size is less than the size of array");
		else 
		{
		int temp=0;
		for(i=0;i<windowSize;i++)
		{
		    sum=sum+arr[i];
		}
		
		for(i=1;i<(n-windowSize+1);i++)
		{
		    temp=sum-arr[i-1];
		    temp=temp+arr[i+windowSize-1];
		    if(temp>sum)
		    sum=temp;
		}
		
		System.out.println(sum);
		}
	}
}
