package solutions;

import java.util.ArrayList;
import java.util.Arrays;

public class SubsetOfSpecificSum {
	
	public static ArrayList<Integer> subset_of_given_sum(int []input, int sum)
	{
		int rem = 0, list_sum=0;
	    ArrayList<Integer> res_list = new ArrayList<Integer>();
	    
	    for(int i=0; i<input.length; i++)
	    {
	    	if(input[i]<=sum)
	    	{ 
	    		list_sum = 0;
	    		for(int j=0; j<res_list.size(); j++)
	    			list_sum = list_sum+res_list.get(j);
	    		rem = sum-list_sum;
    			
	    		if(rem<input[i])
	    		{
	    			rem = rem+res_list.get(res_list.size()-1);
	    			res_list.remove(res_list.size()-1);
	    			
	    		}
	    		res_list.add(input[i]);
	    		if(rem-input[i]==0)
	    			return res_list;
	    	}
	   }
	   return null;
	}

	public static void main(String[] args) {
		int[] input = {12, 1, 61, 5, 9, 2};
		int sum = 24;
		
		System.out.println("Input Array is: "+ Arrays.toString(input));
		System.out.println("Given sum is: "+ sum);
		System.out.println("Resultant subarray having given sum is: "+ subset_of_given_sum(input, sum).toString());

	}

}
