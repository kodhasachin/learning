package google;

public class LastIndexOfSubString {

	public static int last_index_of_sub_string(String parent, String sub_str)
	{
		int j=0, index=0, final_idx=0;
		for(int i=0; i<parent.length(); i++)
		{
			index=i;
			while(j<sub_str.length() && i<parent.length() && parent.charAt(i)==sub_str.charAt(j))
			{
				j++;
				i++;
			}
			if(j==sub_str.length())
				final_idx=index;
			else
				index=0;
			j=0;
		}
		return final_idx;
	}

	public static void main(String[] args) {
		String parent = "sacghinacg";
		String sub_str = "acg";
		System.out.println("Parent String is: "+ parent);
		System.out.println("Sub String is: "+ sub_str);
		System.out.println("First Index of substring in parent string is: "+last_index_of_sub_string(parent, sub_str));

	}
}
