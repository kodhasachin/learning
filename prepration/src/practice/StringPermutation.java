package practice;

public class StringPermutation {
	
	public static void permute(String str, int s, int e)
	{
		if(s==e)
			System.out.println(str);
		else
		{
			for(int i=s; i<str.length(); i++)
			{
				str=swap(str,s,i);
				permute(str, s+1, e);
				str=swap(str,s,i);
			}
			
		}
	}
	
	public static String swap(String str, int i, int j)
	{
		char[] tmp=str.toCharArray();
		char tmp_char = tmp[i];
		tmp[i]=tmp[j];
		tmp[j]=tmp_char;
		return String.valueOf(tmp);
		
	}
	
	

	public static void main(String[] args)
	{
		String str = "ABC";
		System.out.println("Given string is: "+str);
		permute(str, 0, 2);
	}

}
