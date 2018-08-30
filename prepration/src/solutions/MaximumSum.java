package solutions;

public class MaximumSum {
	
	public static int maximum_sum(int [] arr)
	{
		int inc = arr[0];
		int exc = 0;
		for(int i=1; i<arr.length; i++)
		{
			int old_inc = inc;
			inc = exc+arr[i];
			if(exc<old_inc)
				exc=old_inc;
		}
		
		return exc>inc?exc:inc;
		
	}

	public static void main(String[] args) {
		int [] arr = {5,  5, 10, 40, 50, 35};
		//int [] arr = {1,2,3,4};
		System.out.println("Maximum sum of non-adjacent elements is: "+maximum_sum(arr));

	}

}
