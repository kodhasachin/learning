package solutions;

import java.util.*;

public class OptimalMemoryUse {
	
	public static ArrayList<List<Integer>> memoryuse(int devicecap, List<List<Integer>> fore,List<List<Integer>> back)
	{
		HashMap<Integer, Integer> foreground = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> background = new HashMap<Integer, Integer>();
		
		HashMap<Integer, ArrayList<Integer>> result = new HashMap<Integer, ArrayList<Integer>>();
		ArrayList<List<Integer>> final_result = new ArrayList<List<Integer>>();
		int min = 0;
		
		for(List list:fore)
			foreground.put((int)list.get(0), (int)list.get(1));
		for(List list:back)
			background.put((int)list.get(0), (int)list.get(1));
		
		for(int foreprocess:foreground.keySet())
		{
			for(int backprocess: background.keySet())
			{
				ArrayList<Integer> temp_list = new ArrayList<Integer>();
				temp_list.add(foreprocess);
				temp_list.add(backprocess);
				int diff = devicecap - foreground.get(foreprocess)-background.get(backprocess);
				
				if(diff==0)
				{
					final_result.add(temp_list);
				}
				else if(diff>0)
					min=Math.min(min, diff);
			}
		}
		if(final_result.size()==0)
			final_result.add(result.get(min));
		
		return final_result;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
