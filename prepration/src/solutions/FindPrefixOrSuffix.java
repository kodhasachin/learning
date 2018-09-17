package solutions;

public class FindPrefixOrSuffix {
	
//	public static String find_prefix_or_suffix(String str1, String str2, boolean is_prefix)
//	{
//		String output = "";
//		int i=0,j=0;
//		if(!is_prefix)
//		{
//			while(i<str1.length() && j<str2.length() && str1.charAt(i)!=str2.charAt(j))
//			{
//				i++;
//				j++;
//			}
//		}
//		System.out.println("i="+i+" & j="+j);
//		while(i<str1.length() && j<str2.length() && str1.charAt(i)==str2.charAt(j))
//		{
//			output=output+str1.charAt(i);
//			i++;
//			j++;
//		}
//		
//		
//		return output;
//	}
	
	public static String find_prefix_or_suffix(String str1, String str2, boolean is_prefix)
	{
		String output = "";
		String tmp1=str1;
		String tmp2=str2;
		int i=0,j=0;
		if(!is_prefix)
		{
			tmp1=reverse_string(tmp1);
			tmp2=reverse_string(tmp2);
		}
		
		while(i<tmp1.length() && j<tmp2.length() && tmp1.charAt(i)==tmp2.charAt(j))
		{
			output=output+tmp1.charAt(i);
			i++;
			j++;
		}
		
		if(is_prefix)
			return output;
		else
			return reverse_string(output);
	}
	
	public static String reverse_string(String str)
	{
		if(str.length()==1)
			return str;
		else
			return str.charAt(str.length()-1)+reverse_string(str.substring(0, str.length()-1));
	}

	public static void main(String[] args) {
		String str1 = "sachinsuf";
		String str2 = "sacsuf";
		System.out.println("First string is: "+str1);
		System.out.println("Second string is: "+str2);
		
		System.out.println("Common Prefix is: "+find_prefix_or_suffix(str1,str2,true));
		System.out.println("Common Suffix is: "+find_prefix_or_suffix(str1,str2,false));

	}

}
