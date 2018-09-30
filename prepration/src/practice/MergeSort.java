package practice;

import java.util.Arrays;

public class MergeSort {
	
	public static void merge_sort(int[] arr, int s, int e)
	{
		if(s<e)
		{
			int mid = (s+e)/2;
			merge_sort(arr, s, mid);
			merge_sort(arr, mid+1, e);
			merge(arr, s, mid, e);
		}
	}
	
	public static void merge(int[] arr, int s, int m, int e)
	{
		int[] left = new int[m-s+1];
		int[] right = new int[e-m];
		
		for(int i=0; i<left.length; i++)
			left[i] = arr[s+i];
		for(int j=0; j<right.length; j++)
			right[j] = arr[m+j+1];
		
		int i=0, j=0, k=s;
		
		while(i<left.length && j<right.length)
		{
			if(left[i]>right[j])
			{
				arr[k]=right[j];
				j++;
			}
			else if(left[i]<right[j])
			{
				arr[k]=left[i];
				i++;
			}
			else 
			{
				arr[k]=left[i];
				i++;
				j++;
			}
			k++;
		}
		while(i<left.length)
		{
			arr[k]=left[i];
			k++;
			i++;
		}
		while(j<right.length)
		{
			arr[k]=right[j];
			k++;
			j++;
		}
	}

	public static void main(String[] args) {
		int[] arr = {3,5,1,7,2};
		System.out.println("Given Array is: "+Arrays.toString(arr));
		merge_sort(arr, 0, 4);
		System.out.println("Sorted Array is: "+Arrays.toString(arr));

	}

}
