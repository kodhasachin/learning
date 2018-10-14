package solutions;

import java.util.Arrays;

public class FindKthSmallestElement {
	
	public static int find_kth_smallest_element(int[] input, int k)
	{
		Arrays.sort(input);
		int count=1, i=0;
		while(i+1<input.length && count<=k)
		{
			if(input[i]!=input[i+1])
			{
				count++;
				i++;
			}
			else
				i++;
		}
		return input[count];
		
	}

	public static void main(String[] args) {
		
		int[] input = {3,2,6,1,1,2,5};
		System.out.println("Input Array is: "+Arrays.toString(input));
		System.out.println("3rd smallest element in array is: "+find_kth_smallest_element(input, 4));
		
		

	}

}
