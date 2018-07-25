package learning;

import java.util.HashSet;

public class Box {
	
	public int maximum_diff(int [] arr)
	{
//		HashSet<Integer> out = new HashSet<Integer>();
		int temp = 0;
		for(int i=1;i<arr.length;i++)
		{
			for(int j=0;j<i;j++)
			{
				if(arr[i]>arr[j])
				{
					if(temp<arr[i]-arr[j])
						temp=arr[i]-arr[j];
				}
			}
		}
		return temp;
	}

	public static void main(String[] args) {
		//int [] arr = {2, 3, 10, 2, 4, 8, 11, 13};
		int [] arr = {10, 8, 7, 6, 5};
		Box b = new Box();
		System.out.println("Maximum difference is: "+ b.maximum_diff(arr));

	}

}
