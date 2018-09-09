package solutions;

import java.util.Arrays;

public class SumOfArrayDiagonals {
	
	public static int sum_of_diagonals(int[][] input)
	{
		int result=0, k=0;
		while(k<input.length)
		{
			result=result+input[k][k];
			k++;
		}
		for(int i=0,j=input.length-1; i<input.length; i++,j--)
		{
			if(i!=j)
				result = result+input[i][j];
		}
		return result;
	}

	public static void main(String[] args) {
		
//		int[][] input = {{3,4,5,3,5}, 
//				 		 {6,7,8,3,5},
//				 		 {1,2,1,3,5},
//				 		 {1,2,3,4,5},
//				 		 {1,2,3,4,5}};
		int[][] input = {{1,2,3}, 
		 		 {1,2,3},
		 		 {1,2,3}};
		System.out.println("Input Array is: "+Arrays.deepToString(input));
		System.out.println("Sum of both diagonals are: "+sum_of_diagonals(input));

	}

}
