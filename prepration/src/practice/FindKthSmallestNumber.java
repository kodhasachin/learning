package practice;

import java.util.Arrays;

public class FindKthSmallestNumber {
	
	public static int kth_smallest_element(int[] input, int k)
	{
		Arrays.sort(input);
		System.out.println("Sorted array is: "+Arrays.toString(input));
		int count=0;
		int i=0;
		
		while ((i+1)<input.length && count!=k)
		{
			if(input[i]!=input[i+1])
				count++;
			i++;
		}
		if(count==k-1)
			return input[i];
		else
			return input[i-1];
	}

	public static void main(String[] args) {
		int[] input = {3,4,1,1,6,3,5,5,7,6,4};
		int k=6;
		System.out.println("Given integer array is: "+ Arrays.toString(input));
		System.out.println("Kth smallest integer is: "+kth_smallest_element(input, k));

	}

}
