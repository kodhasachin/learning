package solutions;

import java.util.Arrays;

public class GoogleBadColumns {
	
	public static int bad_columns(char[][] input)
	{
		int count = 0;
		
		for(int i=0; i<input[0].length; i++)
		{
			for(int j=0; j<input.length-1; j++)
			{
				if(input[j][i]>input[j+1][i])
				{
					count++;
					break;
				}
					
			}
		}
		
		return count;
	}

	public static void main(String[] args) {
		char[][] input = {{'c','b','a'},{'d','a','f'},{'g','h','i'}};
		//char[][] input = {{'z','y','x'},{'w','v','u'},{'t','s','r'}};
		//char[][] input = {{'a','b','c','d','e','f'}};
		System.out.println("Input array is: "+Arrays.deepToString(input));
		
		System.out.println("Number of columns needs to removed: "+bad_columns(input));

	}

}
