package learning;

import java.util.Arrays;
import java.util.HashMap;

public class NullifyMatrix {
	
	public static int[][] nullifymatrix(int[][] arr)
	{
		int [][] output = new int[arr.length][arr[0].length];
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int i=0; i<arr.length; i++)
		{
			for(int j=0; j<arr[0].length; j++)
			{
				if(arr[i][j]==0)
					map.put(i, j);
			}
		}
		return output;
	}

	public static void main(String[] args) {
		int [][] arr = {
				{1, 2, 3},
				{4, 5, 6},
				{7, 8, 9}
		};
		
		System.out.println("Rotated array is: "+Arrays.deepToString(nullifymatrix(arr)));

	};

	

}
