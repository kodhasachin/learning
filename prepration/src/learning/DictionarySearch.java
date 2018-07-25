package learning;

import java.util.HashSet;

public class DictionarySearch {
	
	public static HashSet<String> set = new HashSet<String>();
	public static void makingSet()
	{
		set.add("i");
		set.add("love");
		set.add("coffee");
		set.add("monkey");
		set.add("monk");
		set.add("eye");
	}
	
	public static String make_word(char[] a)
	{
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<a.length;i++)
			sb.append(a[i]);
		return sb.toString();
	}
	
	public static boolean find_word(String str, int s, int e)
	{
		while(s<e)
		{
			if(set.contains(str.charAt(s)))
				return true;
			else
			{
				return find_word(str, s, e);
			}
		}
		
		return false;
		
	}

	public static void main(String[] args) {
		

	}

}
