package solutions;

import java.util.Arrays;

public class NearestTensSum {
	
	public static int nearest_tens_sum(int[] input)
	{
		int result=0;
		for(int i=0; i<input.length; i++)
			result=result+nearest_ten(input[i]);
		return result;
	}
	
	public static int nearest_ten(int num)
	{
		int nearest_ten = (num/10)*10;
		if(num-nearest_ten > 5)
			nearest_ten=nearest_ten+10;
		return nearest_ten;
			
	}

	public static void main(String[] args) {
		
		int[] input = {12,18,23,29};
		System.out.println("Given array is: "+Arrays.toString(input));
		System.out.println("Resultant array is: "+nearest_tens_sum(input));

	}

}
