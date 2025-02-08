
//Bubble Sort - Brute Force approach o(n2)

import java.util.Scanner;

class BubbleSort {
    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        
        for(int i=0;i<n;i++)
        arr[i]=sc.nextInt();
        int temp;
        for(int i=0;i<n-1;i++)
        for(int j=i+1;j<n;j++)
        {
            if(arr[i]>arr[j])
            {
                temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        for(int x:arr)
        System.out.println(x);
    }
}
