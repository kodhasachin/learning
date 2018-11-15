package practice;

import java.util.Arrays;

public class SumOfArray {
	
	public static boolean is_subarray_exist(int[] input, int num)
	{
		int left=0, right=0;
		int sum=0;
		while(right!=input.length)
		{
			int rem = num-sum;
			if(rem==0)
				return true;
			if(rem>input[right])
			{
				sum=sum+input[right];
			}
			else
			{
				sum=sum-input[left];
				sum=sum+input[right];
				left++;
			}
			right++;
		}
		return false;
	}

	public static void main(String[] args) {
		int[] input = {5,4,2,3,8,9};
		int num = 17;
		System.out.println("Input array is: "+Arrays.toString(input));
		System.out.println("Given number is: "+num);
		System.out.println("Is there any sub-array exist having sum as given number: "+is_subarray_exist(input, num));

	}

}
