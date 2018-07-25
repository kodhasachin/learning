package learning;

import java.util.Arrays;

public class Matrix90rotation {
	
	public static int[][] rotateMatrix(int [][] arr)
	{
		for(int i=0; i<arr.length; i++)
		{
			for(int j=arr.length-1; j>i; j--)
			{
//				if(i!=j)
//				{
					int tmp = arr[i][j];
					arr[i][j]=arr[j][i];
					arr[j][i]=tmp;
//				}
			}
		}
		return arr;
	}

	public static void main(String[] args) {
		
		int [][] arr = {
				{1, 2, 3},
				{4, 5, 6},
				{7, 8, 9}
		};
		
		System.out.println("Rotated array is: "+Arrays.deepToString(rotateMatrix(arr)));

	};

}
