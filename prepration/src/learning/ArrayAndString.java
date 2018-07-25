package learning;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;


public class ArrayAndString {
	
	public boolean is_unique(String str)
	{
		Hashtable<Character, Integer> tab = new Hashtable<Character, Integer>();
		for(int i=0; i<str.length(); i++)
		{
			Character c = str.charAt(i);
			if(tab.containsKey(c))
			{
				tab.put(c, tab.get(c)+1);
			}
			else
				tab.put(c, 1);
		}
		for(Character c:tab.keySet())
		{
			if(tab.get(c)>1)
				return false;
		}
		return true;
	    
	}
	
	public boolean is_permutation(String str1, String str2)
	{
		char [] arr1 = str1.toCharArray();
		char [] arr2 = str2.toCharArray();
		
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		
		if(Arrays.equals(arr1, arr2))
			return true;
		else
			return false;
	}
	
	public boolean is_permutation_without_ds(String str1, String str2)
	{
		if(Math.abs(str1.length()-str2.length())>0)
			return false;
		
		int [] chars = new int[128];
		
		for(int i=0; i<str1.length(); i++)
		{
			chars[str1.charAt(i)]=chars[str1.charAt(i)]+1;
			
		}
		for(int j=0; j<str1.length(); j++)
		{
			chars[str2.charAt(j)] = chars[str2.charAt(j)]-1;
			if(chars[str2.charAt(j)]<0)
				return false;
		}
		return true;
	}
	
	public String remove_spaces(String str, int len)
	{
		
		char [] arr = str.toCharArray();
		int space_count = 0;
		for(int i =0; i<len; i++)
		{
			if(arr[i] == ' ')
				space_count++;
		}
		System.out.println("space count: "+space_count);
		int index = len+space_count*2;
		System.out.println("idex is: "+index);
		
		for(int i=len-1; i>=0; i--)
		{
			if(arr[i]==' ')
			{
				arr[index-1]='0';
				arr[index-2]='2';
				arr[index-3]='%';
				index = index-3;
			}
			else
			{
				arr[index-1]=arr[i];
				index = index-1;
			}
		}
		return String.valueOf(arr);
		
	}
	
	public boolean is_palindrome_permutation(String str)
	{
		int even, odd =0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i=0; i<str.length(); i++)
		{
			if(map.containsKey(str.charAt(i)))
				map.put(str.charAt(i), map.get(str.charAt(i))+1);
			else
				map.put(str.charAt(i), 1);
		}
		
		for(Character c:map.keySet())
		{
			if(map.get(c)%2!=0)
				odd++;
			if(odd>1)
				return false;
			
		}
		return true;
		
	}

	public static void main(String[] args) {
		
		ArrayAndString as = new ArrayAndString();
		System.out.println("Is Unique: "+as.is_unique("sachin"));
		System.out.println("Is Permutation: "+as.is_permutation("sachin", "hhinsac"));
		System.out.println("Is Permutation: "+as.is_permutation_without_ds("sachin", "inhsac"));
		System.out.println("URLify: "+as.remove_spaces("Mr John Smith      ", 13));
		System.out.println("Is palindrome permutation: "+as.is_palindrome_permutation("tactcoa"));

	}

}
