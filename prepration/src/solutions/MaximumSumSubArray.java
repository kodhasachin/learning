package solutions;

import java.util.Arrays;

public class MaximumSumSubArray {
	
	public static int maximum_sum_subarray(int [] input)
	{
		int max_sum = input[0];
		
		for(int i=1; i<input.length; i++)
		{
			max_sum=Math.max(input[i], input[i]+max_sum);
			
		}
		return max_sum;
	}

	public static void main(String[] args) {
		
		//int[] input = {-3,2,-4,2,8};
		//int[] input = {2,-1,-2,3,4};
		int[] input = {34, -50, 42, 14, -5, 86};
		System.out.println("Input Array is: "+Arrays.toString(input));
		System.out.println("Maximum Sum of subarray is:"+maximum_sum_subarray(input));

	}

}
