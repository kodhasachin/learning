package solutions;

import java.util.Arrays;

public class OutOfOrderInversions {
	
	public static int sort(int[] input, int s, int e)
	{
		int count=0;
		if(s<e)
		{
			int mid = (s+e)/2;
			count = sort(input, s, mid);
			count = count+sort(input, mid+1, e);
			count = count+merge(input, s,mid,e);
		}
		return count;
	}
	
	public static int merge(int[] input, int s, int m, int e)
	{
		int count = 0;
		//int[] res = new int[input.length];
		int[] left = new int[m-s+1];
		int[] right = new int[e-m];
		
		for(int i=0; i<left.length; i++)
		{
			left[i]=input[s+i];
		}
		
		for(int j=0; j<right.length; j++)
		{
			right[j]=input[m+1+j];
		}
		
		int i=0, j=0, k=s;
		while(i<left.length && j<right.length)
		{
			if(left[i]<right[j])
			{
				input[k]=left[i];
				i++;
			}
			else if(left[i]>right[j])
			{
				input[k]=right[j];
				j++;
				count=count+left.length-i;
			}
			else
			{
				input[k]=left[i];
				i++;
				j++;
			}
			k++;	
		}
		
		while(i<left.length)
		{
			input[k]=left[i];
			k++;
			i++;
		}
		while(j<right.length)
		{
			input[k]=right[j];
			j++;
			k++;
		}
		
		System.out.println("Sorted Array is: "+Arrays.toString(input));
		
		return count;
	}

	public static void main(String[] args) {
		//int[] input = {2, 4, 1, 3, 5};
		int[] input = {5, 4, 3, 2, 1};
		//int[] input = {1,2,3,4,5};
		System.out.println("Input array is: "+Arrays.toString(input));
		//System.out.println("Total number of inversions are as: "+out_of_order_inversions(input));
		System.out.println("Total Inversion is: "+sort(input, 0, 4));

	}

}
