package solutions;

import java.util.Arrays;

public class SegregateValues {
	
	public static char[] segregate_values(char[] input)
	{
		int low=0, mid=0, high=input.length-1;
		while(mid<=high)
		{
			switch(input[mid])
			{
				case 'R':
				{
					char tmp = ' ';
					tmp = input[mid];
					input[mid]=input[low];
					input[low]=tmp;
					mid++;
					low++;
					break;
				}
				case 'B':
				{
					char tmp = ' ';
					tmp = input[mid];
					input[mid]=input[high];
					input[high]=tmp;
					high--;
					break;
				}
				case 'G':
					mid++;
					break;
			}
				
		}
		
		return input;
	}
	
	public static char[] segregate_array_with_only_two_characters(char[] input)
	{
		int low=0, high=input.length-1;
		while(low<high)
		{
			switch(input[low])
			{
			case 'R':
			{
				low++;
				break;
			}
			case 'B':
			{
				char tmp = ' ';
				tmp = input[high];
				input[high]=input[low];
				input[low]=tmp;
				high--;
				break;
				
			}
			}
			
		}
		return input;
	}
	

	public static void main(String[] args) {
		char[] input = {'G', 'B', 'R', 'R', 'B', 'R', 'G'};
		System.out.println("Character array is: "+Arrays.toString(input));
		System.out.println("Segregated Array is: "+Arrays.toString(segregate_values(input)));
		
		char[] input1 = {'B', 'R', 'R', 'B', 'R', 'B'};
		System.out.println("Character array with only two charcters is: "+Arrays.toString(input1));
		System.out.println("Segregated Array with only two charcters is: "+Arrays.toString(segregate_array_with_only_two_characters(input1)));

	}

}
