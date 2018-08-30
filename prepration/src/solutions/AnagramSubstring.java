package solutions;

import java.util.HashMap;

public class AnagramSubstring {
	
	public static boolean is_anagram_exists(String s1, String s2)
	{
		for(int i=0; i<s1.length()-s2.length(); i++)
		{
			if(is_anagram(s1.substring(i, i+s2.length()), s2))
				return true;
		}
		return false;
	}
	public static boolean is_anagram(String s1, String s2)
	{
		HashMap<Character, Integer> map1=new HashMap<Character, Integer>();
		HashMap<Character, Integer> map2=new HashMap<Character, Integer>();
		for(int i=0; i<s1.length(); i++)
		{
			if(map1.containsKey(s1.charAt(i)))
				map1.put(s1.charAt(i), map1.get(s1.charAt(i))+1);
			else
				map1.put(s1.charAt(i),1);
		}
		for(int i=0; i<s2.length(); i++)
		{
			if(map2.containsKey(s2.charAt(i)))
				map2.put(s2.charAt(i), map2.get(s2.charAt(i))+1);
			else
				map2.put(s2.charAt(i),1);
		}
		for(char c:map1.keySet())
		{
			if(map2.containsKey(c)&&map2.get(c)==map1.get(c))
				continue;
			else
				return false;
				
		}
		return true;
			
	}

	public static void main(String[] args) {
		String s1 = "abdcbad", s2="bad";
		System.out.println("Is '"+s1+"' having anagram of '"+s2+"' :"+is_anagram_exists(s1, s2));
	}

}
