package dailycoding;

import java.util.HashMap;

public class DistinctCharacterSubstring {
	
	public static int length_Distinct_Chars_substring(String str, int k)
	{
		HashMap<Character, Integer> hs = new HashMap<Character, Integer>();
		int maxlen = 0, l=0;
		int[] range = {0,0};
		
		for(int i=0; i<str.length(); i++)
		{
			hs.put(str.charAt(i), i);
			if(hs.size()<=k)
				l=range[0];
			else
			{
				char key = get_minimum_value_key(hs, str.charAt(i));
				l=hs.get(key)+1;
				hs.remove(key);
			}
		range[0]=l;
		range[1]=range[1]+1;
		if(maxlen<range[1]-range[0])
			maxlen = range[1]-range[0];
		}
		return maxlen;
	}
	
	public static char get_minimum_value_key(HashMap<Character, Integer> hs, char c)
	{
		
		Character out = c;
		int min=hs.get(c);
		for(char ch:hs.keySet())
		{
			if(min>=hs.get(ch))
			{
				min = hs.get(ch);
				out = ch;
			}
		}
		System.out.println("Retrned char is: "+out);
		return out;
			
		
	}

	public static void main(String[] args) {
		String str = "abbccca";
		int val=1;
		System.out.println("Input String is: "+str);
		System.out.println("The length of longest substring having atmost "+val+" charcters: "+length_Distinct_Chars_substring(str, val));

	}

}
