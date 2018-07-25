package dailycoding;

import java.util.HashSet;

public class DailyCoding1 {
	
	public static boolean is_sum_exists(int []a, int num)
	{
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i:a)
		{
			if(i<num)
			{
				if(set.contains(num-i))
					return true;
				else
					set.add(i);
			}
		}
		return false;
		
		
	}

	public static void main(String[] args) {
		
		int[] input = {10, 15, 3, 7};
		int k = 17;
		
		System.out.println("Is array conatins required numbers to sumup "+k+": "+is_sum_exists(input, k));

	}

}
