package solutions;

import java.util.*;

public class PointsInSameLine {
	
	public static int maximum_points_in_same_line(ArrayList<int[]> given_points)
	{
		int max_points = 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int i=0; i<given_points.size(); i++)
		{
			for(int j=i+1; j<given_points.size(); j++)
			{
				int slp = slope(given_points.get(i), given_points.get(j));
				
				if(map.containsKey(slp))
					map.put(slp, map.get(slp)+1);
				else
					map.put(slp, 1);
				max_points=Math.max(max_points, map.get(slp));
			}
			
			map.clear();
		}
		return max_points;
	}
	
	public static int slope(int[] pt1, int[] pt2)
	{
		return (pt2[1]-pt1[1])-(pt2[0]-pt1[0]);
	}

	public static void main(String[] args) {
		
	ArrayList<int[]> given_points = new ArrayList<int[]>();
	
	int[] pt1 = {-1, 1};
	int[] pt2 = {0, 0};
	int[] pt3 = {1, 1};
	int[] pt4 = {2, 2};
	int[] pt5 = {3, 3};
	int[] pt6 = {3, 4};
	
	given_points.add(pt1);
	given_points.add(pt2);
	given_points.add(pt3);
	given_points.add(pt4);
	given_points.add(pt5);
	given_points.add(pt6);
	
	System.out.print("Given point coordinates are: ");
	for(int[] point:given_points)
		System.out.print(Arrays.toString(point));
	
	System.out.println("\nMaximum points fall in same line are: "+maximum_points_in_same_line(given_points));

	}

}
