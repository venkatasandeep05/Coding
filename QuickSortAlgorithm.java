public class QuickSortAlgorithm
{
    public static void quickSort(int arr[],int low,int high)
   {
       if(low<high)
       {
           int pivot=partition(arr,low,high);
           
           quickSort(arr,low,pivot-1);
           quickSort(arr,pivot+1,high);
       }
   }
   public static int partition(int arr[],int low,int high)
   {
       int pivot=arr[high];
       int i=low-1;
       
       for(int j=low;j<=high-1;j++)
       {
           if(arr[j]<=pivot)
           {
               i++;
               swap(arr,j,i);
           }
       }
       swap(arr,i+1,high);
       return i+1;
   }
   
   public static void swap(int arr[],int i,int j)
   {
       int temp;
       temp=arr[i];
       arr[i]=arr[j];
       arr[j]=temp;
   }
	public static void main(String[] args) 
	{
		int arr[]=new int[]{3,5,2,8,19,13,7,9};
		int n=arr.length;
		quickSort(arr,0,n-1);
		for(int x:arr)
		System.out.println(x);
	}
}
