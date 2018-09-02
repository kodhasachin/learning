package solutions;

public class Google {
	
	public static int find_first_index_substring(String str1, String sub)
	{
		int j=0, index=0;
		for(int i=0; i<str1.length(); i++)
		{
			index=i;
			while(j<sub.length() && i<str1.length() && str1.charAt(i)==sub.charAt(j))
			{
				i++;
				j++;
			}
			
//			if(j==sub.length())
//				break;
//			else
//				index=0;
			if(j!=sub.length())
				index=0;
			j=0;
		}
		return index;
	}

	public static void main(String[] args) {
		String main = "sacghinac";
		String sub = "acg";
		
		System.out.println("Parent String is: "+main);
		System.out.println("SubString is: "+sub);
		System.out.println("First index of sub-string is: "+find_first_index_substring(main, sub));

	}

}
