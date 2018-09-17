package solutions;

import java.util.Arrays;

public class FindSubArrayOfGivenNumber {
	
	public static boolean is_subarray_exist(int[] input, int num)
	{
		boolean result=false;
		int left=0, right=0, sum=0, rem=0;
		while(right<input.length)
		{
			rem = num-sum;
			if(rem==0)
				return true;
			if(rem<input[right])
			{
				sum=sum-input[left];
				left++;
			}
			else
			{
				sum = sum+input[right];
				right++;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] input = {5,4,2,3,8,9};
		int num = 15;
		System.out.println("Input array is: "+Arrays.toString(input));
		System.out.println("Given number is: "+num);
		System.out.println("Is there any sub-array exist having sum as given number: "+is_subarray_exist(input, num));

	}

}
