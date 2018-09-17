package practice;

import java.util.HashMap;
import java.util.Map;

public class LongestNonRepeatingCharSubString {
	
	public static int length_non_repeating_character_substring(String str)
	{
		int max=0;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i=0; i<str.length(); i++)
		{
			if(map.containsKey(str.charAt(i)))
			{
				max=Math.max(max, map.size());
				i=map.get(str.charAt(i));
				map.clear();
			}
			else
			{
				map.put(str.charAt(i), i);
			}
		}
		return max;
	}

	public static void main(String[] args) {
		String input = "abcadca";
		System.out.println("Input String is: "+input);
		System.out.println("Length of longest Non-Repeating character string is: "
		+length_non_repeating_character_substring(input));

	}

}
