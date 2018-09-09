package solutions;

import java.util.Arrays;

public class SumOfTwoArraysElements {
	
	public static int[] sum_of_each_elements(int[] input1, int[] input2)
	{
		if(input1.length>input2.length)
		{
			int diff = input1.length-input2.length;
			for(int i=diff; i<input1.length; i++)
			{
				input1[i]=input1[i]+input2[i-diff];
			}
			return input1;
		}
		else
		{
			int diff = input2.length-input1.length;
			for(int i=diff; i<input2.length; i++)
			{
				input2[i]=input2[i]+input1[i-diff];
			}
			return input2;
		}
			
		
	}

	public static void main(String[] args) {
		int[] input1 = {1,1,2};
		int[] input2 = {4,3};
		
		System.out.println("First Input Array is: "+Arrays.toString(input1));
		System.out.println("Second Input Array is: "+Arrays.toString(input2));
		
		System.out.println("Resultant array of having sum of each elements of both array: "
		+Arrays.toString(sum_of_each_elements(input1, input2)));

	}

}
