package learning;

public class Amazon {
	
	/*There are 3 types are of edit that can be performed on strings: Insert a character, Remove a character 
	or Replace a Charcter.
	Given two strings, write a function to check if there are one or zero edits away.
	For example:
		pale, ple -> true
		pales, pale -> true
		pale, bale -> true
		pale, bake -> false*/
	public boolean is_edited(String str1, String str2)
	{
		int res = 0;
		int len1 = str1.length();
		int len2 = str2.length();
		char [] arr1 = str1.toCharArray();
		char [] arr2 = str2.toCharArray();
		
		if(len1-len2 >=2)
			return false;
		if(len1-len2 == 0)
		{
			for(int i=0; i<len1; i++)
			{
				if(arr1[i]!=arr2[i])
					res++;
			}
			if(res>=2)
				return false;
			else
				return true;
		}
		
		if(len1>len2 && len1-len2 == 1)
		{
			for(int i=0; i<len2; i++)
			{
				if(arr1[i]!=arr2[i])
					res++;
			}
			if(res>=2)
				return false;
			else
				return true;
		}
		
		if(len2>len1 && len2-len1 == 1)
		{
			for(int i=0; i<len1; i++)
			{
				if(arr1[i]!=arr2[i])
					res++;
			}
			if(res>=2)
				return false;
			else
				return true;
		}
		return false;
	}
	
	public boolean is_one_away(String first, String second)
	{
		if(Math.abs(first.length()-second.length())>1)
			return false;
		
		int diff = 0;
		if(first.length()==second.length())
		{
			for(int i=0; i<first.length(); i++)
			{
				if(first.charAt(i)!=second.charAt(i))
					diff++;
			}
			
		}
		
		if(first.length()>second.length() && first.length()-second.length() == 1)
		{
			int j=0;
			for(int i=0; i<second.length(); i++)
			{
				if(first.charAt(i)!=second.charAt(i-j))
				{
					diff++;
					j++;
				}
			}
			
			
		}
		
		if(first.length()<second.length() && first.length()-second.length() == 1)
		{
			int j=0;
			for(int i=0; i<first.length(); i++)
			{
				if(second.charAt(i)!=first.charAt(i-j))
				{
					diff++;
					j++;
				}
			}
			
		}
		
		if(diff>1)
			return false;
		else
			return true;
	}

	public static void main(String[] args) {
		
		Amazon amz = new Amazon();

//		
//		int i = 5;
//		i +=3;
//		System.out.println("i+=3:"+i);
//		i=~i;
//		System.out.println("i=~i:"+i);
//		i= i>>5;
//		System.out.println("i>>5:"+i);
//		System.out.println("Is string edited: "+amz.is_edited("pale", "ple"));
		System.out.println("Is string edited: "+amz.is_one_away("pale", "bake"));

	}

}
