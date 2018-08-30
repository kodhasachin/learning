package dailycoding;

import java.util.Arrays;
import java.util.HashMap;

public class MaximumClassRoom {
	
	public static int maximum_classrooms(int [][] timings)
	{
		int current=0, max=0, k=0;
		HashMap<Integer, Character> map = new HashMap<Integer, Character>();
		
		for(int i=0; i<timings.length; i++)
		{
			for(int j=0; j<2; j++)
			{
				if(j==0)
					map.put(timings[i][j], 's');
				else
					map.put(timings[i][j], 'e');
			
				k++;
			}
		}
		int [] tmp = new int[map.size()];
		int index=0;
		for(int c:map.keySet())
		{
			tmp[index]=c;
			index++;
		}
		Arrays.sort(tmp);
		System.out.println("tmp Array is: "+Arrays.toString(tmp));
		for(int c:tmp)
		{
			if(map.get(c)=='s')
			{
				current++;
				if(max<current)
					max = current;
			}
			else
				current--;
		}
		System.out.println("Prepared Array is: "+map.toString());
		return max;
	}
	
	public static int platform_needed(int[] arr, int[] dep)
	{
		int current=0, max=0;
		Arrays.sort(arr);
		Arrays.sort(dep);
		int i=0, j=0;
		
		while(i<arr.length && j<dep.length)
		{
			if(arr[i]<dep[j])
			{
				current++;
				if(max<current)
					max = current;
				i++;
			}
			else
			{
				current--;
				j++;
			}
		}
		return max;
		
	}
	

	public static void main(String[] args) {
		
		int[] arr = {900,  940, 950,  1100, 1500, 1800};
		int[] dep = {910, 1200, 1120, 1130, 1900, 2000};
		
		//int [][] input = {{900, 910},{940,1200},{950,1120},{1100,1130},{1500,1900},{1800,2000}};
		
		//int [][] input = {{30,75},{0,50},{60,150},{5,25}};
//		System.out.println("Input array is: "+Arrays.deepToString(input));
//        System.out.println("Minimum classroom required is: "+maximum_classrooms(input));
        
        System.out.println("Input Arrival array is: "+Arrays.toString(arr));
        System.out.println("Input Departure array is: "+Arrays.toString(dep));
        System.out.println("Minimum pltform required is: "+platform_needed(arr,dep));
	}

}
