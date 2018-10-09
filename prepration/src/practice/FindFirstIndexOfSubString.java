package practice;

public class FindFirstIndexOfSubString {
	
	public static int first_index_of_substring(String par, String sub)
	{
		int j=0;
		for(int i=0; i<par.length(); i++)
		{
			if(par.charAt(i)==sub.charAt(j))
			{
				j++;
				if(j==sub.length())
				{
					return i-j+1;
				}
			}
			
		}
		return -1;
		
	}

	public static void main(String[] args) {
		String str1 = "sachinkodha";
		String str2 = "inko";
		
		System.out.println("Parent String is: "+str1);
		System.out.println("Child String is: "+str2);
		
		System.out.println("First index of substring into parent string is: "+first_index_of_substring(str1, str2));

	}

}
