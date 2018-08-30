package solutions;

import java.util.Arrays;

public class MergeSort {
	
	public static void merge(int[] a, int f, int m, int l)
	{
		//int[] res = new int[a.length];
		
		
		int[] left = new int[m-f+1];
		for(int i=0; i<left.length; i++)
			left[i]=a[f+i];
		System.out.println("Left Array: "+Arrays.toString(left));
		
		int[] right = new int[l-m];
		for(int i=0; i<right.length; i++)
			right[i]=a[m+1+i];
		System.out.println("Right Array: "+Arrays.toString(right));
		
		int i=0, j=0, k=f;
		while(i<left.length && j<right.length)
		{
			if(left[i]<right[j])
			{
				a[k]=left[i];
				i++;
			}
			else if(left[i]>right[j])
			{
				a[k]=right[j];
				j++;
			}
			else{
				a[k]=left[i];
				i++;
				j++;
				
			}
			k++;
		}
		while(i<left.length)
		{
			a[k]=left[i];
			i++;
			k++;
		}
		while(j<right.length)
		{
			a[k]=right[j];
			j++;
			k++;
		}
		//a=res;
		System.out.println("Sorted array is: "+Arrays.toString(a));
	}
	public static void sort(int[] a, int f, int l)
	{
		if(f<l)
		{
			int m = (f+l)/2;
			sort(a, f, m);
			sort(a, m+1, l);
			merge(a, f, m, l);
		}
		
	}

	public static void main(String[] args) {
		//int [] a = {3,4,1,2,6,7,9};
		int [] a = {3,5,1,2};
		
		System.out.println("Given Array is: "+Arrays.toString(a));
		sort(a, 0, 3);
		

	}

}
