package solutions;

public class FindPrefixOrSuffix {
	
	public static String find_prefix_or_suffix(String str1, String str2, boolean is_prefix)
	{
		String output = "";
		int i=0,j=0;
		if(!is_prefix)
		{
			while(i<str1.length() && j<str2.length() && str1.charAt(i)!=str2.charAt(j))
			{
				i++;
				j++;
			}
		}
		System.out.println("i="+i+" & j="+j);
		while(i<str1.length() && j<str2.length() && str1.charAt(i)==str2.charAt(j))
		{
			output=output+str1.charAt(i);
			i++;
			j++;
		}
		
		
		return output;
	}

	public static void main(String[] args) {
		String str1 = "sachinsuf";
		String str2 = "wersuf";
		System.out.println("First string is: "+str1);
		System.out.println("Second string is: "+str2);
		
		System.out.println("Common Prefix is: "+find_prefix_or_suffix(str1,str2,true));
		System.out.println("Common Suffix is: "+find_prefix_or_suffix(str1,str2,false));

	}

}
