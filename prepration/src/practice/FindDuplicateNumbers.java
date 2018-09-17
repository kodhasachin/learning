package practice;

import java.util.Arrays;

public class FindDuplicateNumbers {
	
	public static void get_duplicate_numbers(int[] input)
	{
		for(int i=0; i<input.length; i++)
		{
			int index = input[i]%input.length;
			input[index]=input[index]+input.length;
		}
		for(int i=0; i<input.length; i++)
		{
			if(input[i]/input.length > 1)
				System.out.print(i+" ");
		}
		
	}

	public static void main(String[] args) {
			int[] input = {2,3,2,4,5,5,5,6,3};
			System.out.println("Input array is: "+Arrays.toString(input));
			get_duplicate_numbers(input);
		}

}
