package solutions;

import java.util.Arrays;

public class BinarySearch {
	
	public static int binary_search(int[] arr, int k, int s, int e)
	{
		if(s<=e)
		{
			int mid = (s+e)/2;
			if(arr[mid]==k)
				return mid;
			if(arr[mid]<k)
				return binary_search(arr, k, mid+1, e);
		
				return binary_search(arr, k, s, mid);
			
		}
		else
			return -1;
		
		
	}

	public static void main(String[] args) {
		int[] input = {3,4,1,8,2,5,2,4};
		Arrays.sort(input);
		int k=8;
		System.out.println("Input Array is: "+Arrays.toString(input));
		System.out.println("Number "+k+" exists into input array using binary search: "+binary_search(input, k, 0, 7));
		

	}

}
