package solutions;

import java.util.HashMap;

public class LongestSubstring {
	
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
		return max_len;
	}

	public static void main(String[] args) {
		String str = "abcadca";
		System.out.println("Longest substring length of non-repeated characters for string '"+str+"' is:"+longest_substring_non_repeated_chars(str));

	}

}
