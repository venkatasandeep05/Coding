// Given an array of integers and also a value x. find the pair of integers whose sum is equals to given value x

import java.util.Scanner;
import java.util.*;

public class SumOfTwoNumbersPair
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int arr[]=new int[n];
		for(int i=0;i<n;i++)
		arr[i]=sc.nextInt();
		int x=sc.nextInt();
		Map<Integer,Integer> hashMap=new HashMap<>();
		for(int i=0;i<n;i++)
		{
		    int compliment=x-arr[i];
		    if(!hashMap.containsKey(compliment))
		    {
		        hashMap.put(arr[i],i);
		    }
		    else
		    {
		       System.out.println(compliment);
		       System.out.println(arr[i]);
		       break;
		    }
		}
	}
}
