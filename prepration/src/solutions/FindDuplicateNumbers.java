package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindDuplicateNumbers {
	
	public static List find_duplicate_numbers(int[] input)
	{
		List<Integer> list = new ArrayList<Integer>();
		Arrays.sort(input);
		for(int i=0; i<input.length-1; i++)
		{
			int count=1, index=i;
			while(i+1!=input.length && input[i]==input[i+1])
			{
				count++;
				i++;
			}
			if(count>1)
				list.add(input[index]);
		}
		return list;
		
	}
	
	public static void printing_duplicate_values(int[] input)
	{
		System.out.print("Duplicates numbers are: ");
		for(int i=0; i<input.length; i++)
		{
			if(input[Math.abs(input[i])]>=0)
				input[Math.abs(input[i])]=-input[Math.abs(input[i])];
			else
				System.out.print(Math.abs(input[i])+" ");
		}
		
	}
	
	public static void print_duplicate_numbers(int[] input)
	{
		System.out.println("Duplicate Numbers are: ");
		for(int i=0; i<input.length; i++)
		{
			int index = input[i]%input.length;
			input[index]=input[index]+input.length;
		}
		for(int i=0; i<input.length; i++)
		{
			if(input[i]/input.length>1)
				System.out.print(i+" ");
		}
	}
	

	public static void main(String[] args) {
		int[] input = {2,3,2,4,5,5,5,6,3};
		
//		System.out.println("Duplicate numbers are: "+find_duplicate_numbers(input).toString());
//		Arrays.sort(input);
//		System.out.println("Sorted Array is: "+Arrays.toString(input));
		//printing_duplicate_values(input);
		print_duplicate_numbers(input);
	}

}
