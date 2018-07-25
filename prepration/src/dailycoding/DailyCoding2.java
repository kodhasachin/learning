package dailycoding;

import java.util.Arrays;

public class DailyCoding2 {
	
	//time complex = O(nsquare)
	public static int[] product_of_array(int [] a)
	{
		int[] res = new int[a.length];
		int val = 1, i=0;
		while(i<a.length)
		{
			
			for(int j=0; j<a.length; j++)
			{
				if(j!=i)
					val = val*a[j];
			}
			res[i]=val;
			i++;
			val = 1;
		}
		
		return res;
		
	}
	
	//time complex = O(n)
	public static int[] product_of_array_by_division(int [] a)
	{
		int[] res = new int[a.length];
		int val=1;
		for(int i: a)
			val = val*i;
		for(int i=0; i<a.length; i++)
			res[i]=val/a[i];
		
		return res;
		
	}

	public static void main(String[] args) {
		int [] input = {1, 2, 3, 4, 5};
		System.out.println("Resultant Array is: "+Arrays.toString(product_of_array(input)));
		System.out.println("By division Resultant Array is: "+Arrays.toString(product_of_array_by_division(input)));
		
		

	}

}
