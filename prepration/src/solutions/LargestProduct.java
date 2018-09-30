package solutions;

import java.util.Arrays;

public class LargestProduct {
	
	public static int largest_product(int[] input)
	{
		int result = 0;
		int count = 0;
		for(int a:input)
		{
			if(a<0)
				count++;
		}
		Arrays.sort(input);
		if(count<=1)
		{
			result = input[input.length-1]*input[input.length-2]*input[input.length-3];
		}
		else
		{
			result = Math.max(input[0]*input[1]*input[input.length-1], 
					input[input.length-1]*input[input.length-2]*input[input.length-3]);
		}
		return result;	
	}

	public static void main(String[] args) {
		int[] input = {-10, -10, 5, 2};
		System.out.println("Given array is: "+ Arrays.toString(input));
		System.out.println("Largest product is: "+largest_product(input));

	}

}
