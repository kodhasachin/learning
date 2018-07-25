package learning;

import java.util.Arrays;
import java.util.HashSet;

public class StringPermutation {
	
	public static HashSet<String> set = new HashSet<String>();
	
	public static void permute(String str, int s, int e)
	{
		if(s==e)
		{
			System.out.println(str);
			set.add(str);
		}
			
		else
		{
			for(int i=s; i<=e; i++)
			{
				str=swap(str, s, i);
				permute(str, s+1, e);
				str=swap(str, s, i);
				
			}
		}
		
	}
	
	public static String swap(String str, int s, int e)
	{
		char[] arr = str.toCharArray();
		char tmp = arr[s];
		arr[s]=arr[e];
		arr[e]=tmp;
		return String.valueOf(arr);
	}

	public static void main(String[] args) {
		permute("AABB", 0, 3);
		System.out.println(set.toString());
		
	}

}
