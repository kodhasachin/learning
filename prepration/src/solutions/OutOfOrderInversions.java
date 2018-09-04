package solutions;

import java.util.Arrays;

public class OutOfOrderInversions {
	
	public static int out_of_order_inversions(int[] input)
	{
		int total_inversions=0;
		//int min=input[0];
		int min=0;
		int max=0;
		
		for(int i=0; i<input.length; i++)
		{
			if(input[i]>=max)
				max = input[i];
			if(input[i]<=min)
				min = input[i];
			
			//if(input[i]>=max)
				
		
		}
		
		return total_inversions;
		
		
	}

	public static void main(String[] args) {
		//int[] input = {2, 4, 1, 3, 5};
		//int[] input = {5, 4, 3, 2, 1};
		int[] input = {1,2,3,4,5};
		System.out.println("Input array is: "+Arrays.toString(input));
		System.out.println("Total number of inversions are as: "+out_of_order_inversions(input));

	}

}
