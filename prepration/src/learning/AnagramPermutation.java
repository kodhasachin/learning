package learning;

import java.util.HashMap;

public class AnagramPermutation {
	
	public static boolean is_anagram_exists(String str, String sub_str)
	{
		int i=0;
		while(i<=str.length()-sub_str.length())
		{
			if(is_anagram(str.substring(i,sub_str.length()+i), sub_str))
				return true;
			else
				i++;
					
		}
		
		return false;
		
	}
    public static boolean is_anagram(String s1, String s2)
    {
    	System.out.println("First String is: "+s1);
    	System.out.println("Second String is: "+s2);
    	HashMap<Character, Integer> map1 = new HashMap<Character, Integer>();
    	HashMap<Character, Integer> map2 = new HashMap<Character, Integer>();
    	
    	for(int i=0; i<s1.length(); i++)
    	{
    		if(map1.containsKey(s1.charAt(i)))
    			map1.put(s1.charAt(i), map1.get(s1.charAt(i)));
    		else
    			map1.put(s1.charAt(i), 1);
    	}
    	
    	for(int i=0; i<s2.length(); i++)
    	{
    		if(map2.containsKey(s2.charAt(i)))
    			map2.put(s2.charAt(i), map2.get(s2.charAt(i)));
    		else
    			map2.put(s2.charAt(i), 1);
    	}
    	
    	for(Character c:map1.keySet())
    	{
    		if(!map2.containsKey(c) || !(map2.get(c)==map1.get(c)))
    			return false;
    	}
    	for(Character c:map2.keySet())
    	{
    		if(!map1.containsKey(c) || !(map1.get(c)==map2.get(c)))
    			return false;
    	}
    	return true;
    	
    }
	public static void main(String[] args) {
		String s1="sachinkodha";
		String s2 = "ahdo";
		
		System.out.println("Is anagram exists: "+is_anagram_exists(s1, s2));

	}

}
