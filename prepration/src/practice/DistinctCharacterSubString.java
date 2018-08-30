package practice;

import java.util.Arrays;
import java.util.HashMap;

public class DistinctCharacterSubString {
	
	public static int distinct_char_sub_string(String str, int k)
	{
		int[] range = new int[2];
		range[0]=0;
		range[1]=0;
		int max = 0, l=0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		
		for(int i=0; i<str.length(); i++)
		{
			map.put(str.charAt(i),i);
			if(map.size()<=k)
				l=range[0];
			else
			{
				char c = find_minvalue_key(map);
				l=map.get(c)+1;
				map.remove(c);
			}
			range[0]=l;
			range[1]=range[1]+1;
			if(max<range[1]-range[0])
				max = range[1]-range[0];
			
		}
		return max;
	}
	
	public static char find_minvalue_key(HashMap<Character, Integer> map)
	{
		int[] values = new int[map.size()];
		int i=0;
		char ch = ' ';
		for(Character c:map.keySet())
		{
			values[i]=map.get(c);
			i++;
		}
		Arrays.sort(values);
		for(Character c:map.keySet())
		{
			if(map.get(c)==values[0])
			{
				ch=c;
				break;
			}
			
		}
		System.out.println("Returned char is:"+ch);
		return ch;
	}
	
	public static int maxlen_nonrepeated_char(String str)
	{
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int maxlen = 0;
		
		for(int i=0; i<str.length(); i++)
		{
			if(map.containsKey(str.charAt(i)))
			{
				i=map.get(str.charAt(i));
				if(maxlen<map.size())
					maxlen = map.size();
				map.clear();
				
			}
			else
				map.put(str.charAt(i), i);
		}
		return maxlen;
	}
	
	

	public static void main(String[] args) {
		String str = "abcbcca";
		int k=2;
		System.out.println("Input String is: "+str);
		System.out.println("Number of distict character: "+k);
		System.out.println("Maximum length substring having "+k+" different characters: "+distinct_char_sub_string(str, k));
		System.out.println("Maximum length substring having non-repeated characters: "+maxlen_nonrepeated_char(str));

	}

}
