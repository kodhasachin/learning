package practice;

import java.util.Arrays;

public class MaximumSumOfNonAdjacantValues {
	
	public static int maximum_sum_of_non_adjacant_values(int[] input)
	{
		int inc=input[0], exc=0;
		for(int i=1; i<input.length; i++)
		{
			int old_inc=inc;
			inc = exc+input[i];
			
			exc = Math.max(exc, old_inc);
			
			
		}
		return Math.max(inc, exc);
	}

	public static void main(String[] args) {
		int[] input = {5,4};
		System.out.println("Input Array is: "+ Arrays.toString(input));
		System.out.println("Maximum sum of non adjacent values is: "+maximum_sum_of_non_adjacant_values(input));

	}

}
