package practice;

import java.util.Arrays;

public class MaximumSumSubArray {
	
	public static int maximum_sum_of_subarray(int[] input)
	{
		int max=0;
		for(int i=0; i<input.length; i++)
		{
			max=Math.max(input[i], max+input[i]);
		}
		return max;
	}

	public static void main(String[] args) {
		
		int[] input = {34, -50, 42, 14, -5, 86};
		System.out.println("Input array is: "+Arrays.toString(input));
		System.out.println("Maximum subarray sum is: "+maximum_sum_of_subarray(input));

	}

}
