package learning;

import java.util.Arrays;

public class MergeSortImpl {
	
	public static void sort(int [] arr, int s, int e)
	{
		if(s<e)
		{
			
			int mid = (s+e)/2;
			sort(arr, s, mid);
			sort(arr, mid+1, e);
			merge(arr, s, mid, e);
		}
		
	}
	
	public static void merge(int [] arr, int s, int m, int e)
	{
		int ln = m-s+1;
		int rn = e-m;
		
		int[] left = new int[ln];
		int[] right = new int[rn];
		
		for(int i=0; i<ln; i++)
			left[i]=arr[s+i];
		System.out.println("Left array: "+Arrays.toString(left));
		
		for(int i=0; i<rn; i++)
			right[i]=arr[m+1+i];
		System.out.println("right array: "+Arrays.toString(right));
		
		int i=0, j=0, k=s;
		
		while(i<ln && j<rn)
		{
			if(left[i]<right[j])
			{
				arr[k]=left[i];
				i++;
			}
			else if(left[i]>right[j])
			{
				arr[k]=right[j];
				j++;
			}
			else
			{
				arr[k]=left[i];
				i++;
				j++;
			}
			k++;
		}
		while(i<ln)
		{
			arr[k]=left[i];
			i++;
			k++;
		}
		while(j<rn)
		{
			arr[k]=right[j];
			j++;
			k++;
		}
			
		
		
		
	}
	
	
	
	public static void main(String [] args)
	{
		int[] arr = {3, 7, 5, 8, 1};
		System.out.println("Given array:"+Arrays.toString(arr)+(arr.length-1));
		sort(arr, 0, arr.length-1);
		System.out.println("Sorted array:"+Arrays.toString(arr));
		
	}
	
	
}

