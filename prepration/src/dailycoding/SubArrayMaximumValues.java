package dailycoding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class SubArrayMaximumValues {
	
	public static ArrayList<Integer> subarray_maximumvalues(int[] a, int k)
	{
		ArrayList<Integer> res = new ArrayList<Integer>();
		int a_len = a.length;
		for(int i=0; i<=a_len-k; i++)
		{
			int max = Integer.MIN_VALUE;
			for(int j=i; j<i+k; j++)
			{
				if(max<a[j])
					max = a[j];
			}
			res.add(max);
		}
		return res;
	}
	
	public static ArrayList<Integer> subarray_maximumvalues_optimum(int[] a, int k)
	{
		ArrayList<Integer> res = new ArrayList<Integer>();
		Deque<Integer> q = new LinkedList<Integer>();
		for(int i=0; i<k; i++)
		{
			while(!q.isEmpty() && a[i]>=a[q.peek()])
				q.pop();
			q.add(i);
		}
		
		for(int j=k; j<a.length; j++)
		{
			res.add(q.getFirst());
			//while(!q.isEmpty() && q.getFirst()<=j-k)
				
			
		}
		
		return res;
		
		
	}
	
	

	public static void main(String[] args) {
		int [] arr = {10, 5, 2, 7, 8, 7};
		int k=3;
		
		System.out.println("Given Array is: "+Arrays.toString(arr));
		System.out.println("Given window is: "+k);
		System.out.println("Result is: "+subarray_maximumvalues(arr, k).toString());

	}

}
