package solutions;

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
		String parent = "sacghinacg";
		String sub_str = "acg";
		System.out.println("Parent String is: "+ parent);
		System.out.println("Sub String is: "+ sub_str);
		System.out.println("First Index of substring in parent string is: "+first_index_of_substring(parent, sub_str));

	}

}
