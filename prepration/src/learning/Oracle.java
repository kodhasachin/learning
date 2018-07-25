package learning;

import java.util.Arrays;

public class Oracle {
	
	
    
public static int[] move4sToEnd(int[] arr)
{
	for(int i=0; i<arr.length-1; i++)
	{
		if(arr[i]==4)
		{
			int j=arr.length-1;
			if(arr[j]==4)
			{
				while(arr[j]==4)
				{
					j--;
				}
				if(i==j || i>j)
					break;
				else{
					arr[i]=arr[i]+arr[j];
					arr[j]=arr[i]-arr[j];
					arr[i]=arr[i]-arr[j];
					
				}
			}
			else{
				arr[i]=arr[i]+arr[j];
				arr[j]=arr[i]-arr[j];
				arr[i]=arr[i]-arr[j];
				}
		}
			
	}
	return arr;
}


public static int[] move4sToEndOptimize(int[] arr)
{
	for(int i=0, j=arr.length-1; i<arr.length-1; i++, j--)
	{
		System.out.println("Start of For i= "+i);
		System.out.println("Start of For j= "+j);
		while(arr[i]!=4)
			i++;
		System.out.println("After while loop of  i= "+i);
		while(arr[j]!=4)
			j--;
		System.out.println("After while loop of  j= "+j);
		if(i==j || i>j)
			break;
		else
		{
			arr[i]=arr[i]+arr[j];
			arr[j]=arr[i]-arr[j];
			arr[i]=arr[i]-arr[j];
		}
		
	}
	return arr;
}



public static void swap(int a, int b)
{
	System.out.println("in swap");
	a=a+b;
	b=a-b;
	a=a-b;
	

}

public static int diagonal_sum(int [][]arr)
{
	int value = 0;
	for(int i=0;i<arr.length;i++)
	{
		value=value+arr[i][i];
	}
	for(int i=0; i<arr.length; i++)
	{
		if(i!=arr.length-1-i)
			value=value+arr[i][arr.length-1-i];
	}
	
	return value;
}

public static int diagonal_sum1(int [][]arr)
{
	int value = 0;
	for(int i=0,j=0;i<arr.length;i++,j++)
	{
		value=value+arr[i][j];
	}
	for(int i=0,j=arr.length-1; i<arr.length; i++, j--)
	{
		if(i!=j)
			value=value+arr[i][arr.length-1-i];
	}
	
	return value;
}

	public static void main(String[] args) {
		int [][] arr={{2,2,3,4,2},
				      {6,2,9,2,5},
				      {6,5,2,8,6},
				      {9,2,4,2,2},
				      {2,3,4,1,2}};
		
		int[] arr1 = {1,2,3,4,5,4,2,3,2,4,1,0,2,4,4,0};
		
	//	int[] arr1 = {1,4,3,4,0};
		
		
		System.out.println("Both Diagonal Sum is: "+diagonal_sum1(arr));
		
		
		System.out.println("Input array is:                     "+Arrays.toString(arr1));
		System.out.println("MoveToEnd array is:                 "+Arrays.toString(move4sToEnd(arr1)));
		System.out.println("MoveToEnd array by Optimize way is: "+Arrays.toString(move4sToEndOptimize(arr1)));

	}
	
	

}
