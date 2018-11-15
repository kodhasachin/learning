package practice;

import java.util.Arrays;

public class MaximumSum {
	
	public static int maximum_sum_of_non_adjacant_values(int[] input)
	{
		int inc=input[0];
		int exc=0;
		//int max=0;
		
		for(int i=1; i<input.length-1; i++)
		{
			int old_inc = inc;
			inc = exc+input[i];
			exc = Math.max(old_inc, exc);
		}
		return Math.max(inc, exc);
	}

	public static void main(String[] args) {
		int[] input = {5,4};
		System.out.println("Input Array is: "+ Arrays.toString(input));
		System.out.println("Maximum sum of non adjacent values is: "+maximum_sum_of_non_adjacant_values(input));

	}


}
