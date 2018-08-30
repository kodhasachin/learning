package solutions;

import java.util.HashMap;

public class RepeatingCharacters {
	
	public static char first_non_repeating_charcters(String str)
	{
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		char res = ' ';
		for(int i=0; i<str.length(); i++)
		{
			if(map.containsKey(str.charAt(i)))
				map.put(str.charAt(i), map.get(str.charAt(i))+1);
			else
				map.put(str.charAt(i), 1);
		}
		
		for(int i=0; i<str.length(); i++)
		{
			if(map.get(str.charAt(i))>1)
				res = str.charAt(i);
			
		}
		return res;
	}

	public static void main(String[] args) {
		String str = "sachin";
		System.out.println("First non-rpeating character is: "+first_non_repeating_charcters(str));

	}

}
