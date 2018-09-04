package solutions;

import java.util.Arrays;
import java.util.HashSet;

public class TwoNumberAddition {
	
	public static boolean is_sum_exists(int[] input, int sum)
	{
		HashSet<Integer> num_set = new HashSet<Integer>();
		for(int num:input)
		{
			int diff = sum-num;
			if(num_set.contains(diff))
				return true;
			else
			{
				num_set.add(num);
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int[] input = {10, 15, 3, 7};
		int sum = 18;
		
		System.out.println("Input array is: "+Arrays.toString(input));
		System.out.println("Required sum is: "+ sum);
		System.out.println("Is input array has two numbers whose sumup as sum: "+is_sum_exists(input, sum));

	}

}
