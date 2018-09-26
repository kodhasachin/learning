package solutions;

import java.util.*;

public class LongestNonrepeatedSubstring {
	
	public static String longest_substring_non_repeated_chars_length(String str)
	{
		int max_len = 0;
		String result = "";
		LinkedHashMap<Character, Integer> map = new LinkedHashMap<Character, Integer>();
		for(int i=0; i<str.length(); i++)
		{
			if(map.containsKey(str.charAt(i)))
			{
				if(max_len<map.size())
				{
					max_len = map.size();
					Iterator itr = map.keySet().iterator();
					int start = map.get(itr.next());
					int j=0;
					while(j!=map.size()-2)
					{
						itr.next();
						j++;
					}
						
					int end = map.get(itr.next());
					result = str.substring(start, end+1);
				}
				i=map.get(str.charAt(i));
				map.clear();
				
			}
			else
				map.put(str.charAt(i), i);
		}
		return result;
	}
	
//	private static HashMap sortByValues(HashMap map) { 
//	       List list = new LinkedList(map.entrySet());
//	       // Defined Custom Comparator here
//	       Collections.sort(list, new Comparator() {
//	            public int compare(Object o1, Object o2) {
//	               return ((Comparable) ((Map.Entry) (o1)).getValue())
//	                  .compareTo(((Map.Entry) (o2)).getValue());
//	            }
//	       });
//	}
	
	public static int longest_substring_non_repeated_chars(String str)
	{
		int max_len = 0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i=0; i<str.length(); i++)
		{
			if(map.containsKey(str.charAt(i)))
			{
				if(max_len<map.size())
					max_len = map.size();
				i=map.get(str.charAt(i));
				map.clear();
				
			}
			else
				map.put(str.charAt(i), i);
		}
		System.out.println("Map is: "+map.toString());
		return max_len;
	}

	public static void main(String[] args) {
		String str = "abcadca";
		System.out.println("Length of longest substring of non-repeated characters for string '"+str+"' is: "+longest_substring_non_repeated_chars(str));
		System.out.println("Longest substring of non-repeated characters for string '"+str+"' is: "+longest_substring_non_repeated_chars_length(str));

	}

}
