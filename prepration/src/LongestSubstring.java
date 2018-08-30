import java.util.Arrays;
import java.util.HashMap;

public class LongestSubstring {
	
	public static int longest_substring_len(String str)
	{
		int len = 0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i=0; i<str.length(); i++)
		{
			if(map.containsKey(str.charAt(i)))
			{
				if(map.size()>len)
					len = map.size();
				i = map.get(str.charAt(i));
				map.clear();
			}
			else
				map.put(str.charAt(i), i);
		}
		return len;
	}
	
	public static String longest_substring(String str)
	{
		int len = 0;
		String result = "";
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i=0; i<str.length(); i++)
		{
			if(map.containsKey(str.charAt(i)))
			{
				if(map.size()>len)
				{
					len = map.size();
					int [] res = new int[map.size()];
					int k=0;
					for(Character c:map.keySet())
					{
						res[k]=map.get(c);
						k++;
					}
					Arrays.sort(res);
					result = str.substring(res[0], res[map.size()-1]+1);
						
				}
					
				i = map.get(str.charAt(i));
				map.clear();
			}
			else
				map.put(str.charAt(i), i);
		}
		return result;
	}

	public static void main(String[] args) {
		String str = "ABDEFGABEF";
		System.out.println("Length of longest substring of non-repeated characters in string '"+str+"' is: "+longest_substring_len(str));
		System.out.println("Longest substring of non-repeated characters in string '"+str+"' is: "+longest_substring(str));
	}

}
