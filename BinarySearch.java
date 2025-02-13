// Binary search algorithm which is very efficient for searching if the data set is sorted - time complexity - o(logN)

public class BinarySearch
{
	public static void main(String[] args) 
	{
		int arr[]=new int[]{5,6,9,10,14,19,25,27};
		int x=33,flag=0;
		
		int start=0,end=arr.length-1,mid;
		while(start<=end)
		{
		    mid=(start+end)/2;
		    if(arr[mid]==x)
		    {
		    flag=1;
		    break;
		    }
		    else if(arr[mid]>x)
		    {
		        end=mid-1;
		    }
		    else
		    start=mid+1;
		}
		
		if(flag==1)
		System.out.println("Element found");
		if(flag==0)
		System.out.println("Element not found");
	}
}
