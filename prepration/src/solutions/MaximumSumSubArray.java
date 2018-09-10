package solutions;

import java.util.ArrayList;
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
	
	public static ArrayList print_subarray_of_maximum_sum(int [] input)
	{
		int max = input[0];
		ArrayList<Integer> result = new ArrayList<Integer>();
		result.add(input[0]);
		
		for(int i=1; i<input.length; i++)
		{
			if(input[i]+max>input[i])
			{
				max=input[i]+max;
				
			}
			else
			{
				max=input[i];
				result.remove(i-1);
			}
			result.add(input[i]);
		}
		System.out.println("MAx sum is: "+max);
		return result;
	}

	public static void main(String[] args) {
		
		//int[] input = {-3,2,-4,2,8};
		//int[] input = {2,-1,-2,3,4};
		//int[] input = {-5,4,-2,8};
		int[] input = {34, -50, 42, 14, -5, 86};
		System.out.println("Input Array is: "+Arrays.toString(input));
		System.out.println("Maximum Sum of subarray is:"+maximum_sum_subarray(input));
		System.out.println("Subarray having Maximum Sum is:"+print_subarray_of_maximum_sum(input));

	}

}
