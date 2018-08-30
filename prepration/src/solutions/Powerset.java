package solutions;

import java.util.Arrays;

public class Powerset {
	
	public static void powerset(char[] arr)
	{
		long powerset_size = (long) Math.pow(2, arr.length);
		System.out.println("Total number of sets in powerset: "+powerset_size);
		for(int i=0; i<powerset_size; i++)
		{
			System.out.println("i="+i);
			for(int j=0; j<arr.length; j++)
			{
				//System.out.println("i & (1 << j))"+ (i & (1 << j)));
				//System.out.println("(1 << j): "+ (1 << j));
				System.out.print((i & (1<<j) ));
				if((i & (1<<j) )> 0)
                    System.out.print(arr[j]);
			}
			System.out.println();
		}
	}
	
	public static void powerset_recurrsion(char [] arr)
	{
		char[] sub = new char[arr.length];
		helper(arr,sub,0);
		
		
	}
	public static void helper(char[] arr, char[] sub, int i)
	{
		if(i==arr.length)
			System.out.println(Arrays.toString(sub));
		else
		{
			sub[i]=' ';
			helper(arr, sub, i+1);
			sub[i]=arr[i];
			helper(arr, sub, i+1);
		}
		
	}
	
	public static void main(String[] args) {
		char[] input_arr = {'a', 'b', 'c', 'd'};
		
		System.out.println("Input set: "+Arrays.toString(input_arr));
		powerset_recurrsion(input_arr);
		powerset(input_arr);
		
		

	}

}
