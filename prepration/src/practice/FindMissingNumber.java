package practice;

import java.util.Arrays;

public class FindMissingNumber {
	public static int missing_number(int[] a)
	{
		for(int i=0; i<a.length; i++)
		{
			if(a[i]!=i+1)
				return i+1;
			
		}
		return a.length+1;
		
	}
	
	public static int find_missing_number(int[] input)
	{
		int n=input.length+1;
		int total = n*(n+1)/2;
		int real_total = 0;
		for(int i=0; i<input.length; i++)
			real_total = real_total+input[i];
		return total-real_total;
			
		
	}

	public static void main(String[] args) {
		int[] input = {5,3,1,2};
		System.out.println("Input Array is: "+Arrays.toString(input));
		//System.out.println("Missing Number is: "+missing_number(input));
		System.out.println("Missing Number is: "+find_missing_number(input));

	}

}
