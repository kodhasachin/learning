package solutions;

import java.util.HashMap;

public class AnagramCheck {

	public static boolean check_anagram(String s1, String s2)
	{
		if(s1.length()!=s2.length())
			return false;
		else
		{
			HashMap<Character, Integer> map1 = new HashMap<Character, Integer>();
			HashMap<Character, Integer> map2 = new HashMap<Character, Integer>();
			
			for(int i=0; i<s1.length(); i++)
			{
				if(map1.containsKey(s1.charAt(i)))
					map1.put(s1.charAt(i), map1.get(s1.charAt(i))+1);
				else
					map1.put(s1.charAt(i), 1);
			}
			
			for(int i=0; i<s2.length(); i++)
			{
				if(map2.containsKey(s2.charAt(i)))
					map2.put(s2.charAt(i), map2.get(s2.charAt(i))+1);
				else
					map2.put(s2.charAt(i), 1);
			}
			
			
			for(Character c: map1.keySet())
			{
				if(!map2.containsKey(c) || !(map2.get(c)==map1.get(c)))
					return false;
				
			}
			
			return true;
		}
		
	}
	
	public static boolean check_anagram_optm(String str1, String str2)
	{
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i=0; i<str1.length(); i++)
		{
			if(map.containsKey(str1.charAt(i)))
				map.put(str1.charAt(i), map.get(str1.charAt(i)+1));
			else
				map.put(str1.charAt(i), 1);
		}
		
		for(int i=0; i<str2.length(); i++)
		{
			if(map.containsKey(str2.charAt(i)))
				map.put(str2.charAt(i), map.get(str2.charAt(i)-1));
			else
				return false;
		}
		
		for(char c:map.keySet())
		{
			if(map.get(c)!=null)
				return false;
		}
		return true;
		
	}
	public static void main(String[] args) {
		String str1 = "sachin";
		String str2 = "nichsa";
		
		System.out.println(str1+" and "+str2+" is anagram: "+check_anagram(str1, str2));
		System.out.println(str1+" and "+str2+" is anagram: "+check_anagram_optm(str1, str2));


	}

}
