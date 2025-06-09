package org.example;

public class MergeSort
{
    public static void mergeSort(int arr[], int l, int h)
    {
        if(l<h) {
            int mid=l+(h-l)/2;
            mergeSort(arr, l, mid);
            mergeSort(arr, mid + 1, h);

            merge(arr,l,mid,h);
        }
    }

    private static void merge(int[] arr, int l, int mid, int h)
    {
        int n1=mid-l+1;
        int n2=h-mid;
        int left[]=new int[n1];
        int right[]=new int[n2];
        int temp=l;
        for (int i=0;i<n1;i++) {
            left[i] = arr[temp];
            temp++;
        }
        temp=mid;
        for (int i=0;i<n2;i++)
        {
            temp++;
            right[i]=arr[temp];
        }
        int i=0,j=0;
        while (i<n1 && j<n2)
        {
            if(left[i]<right[j])
            {
                arr[l]=left[i];
                i++;
            }
            else{
                arr[l]=right[j];
                j++;
            }
            l++;
        }
        while (j<n2)
        {
                arr[l] = right[j];
                j++;
                l++;
            }

            while (i<n1) {
                arr[l] = left[i];
                i++;
                l++;
            }
    }

    public static void main( String[] args )
    {
        int arr[]={9,6,3,15,6,8,7,12};
        mergeSort(arr,0,arr.length-1);

        for (int x:arr)
            System.out.println(x);
    }
}
