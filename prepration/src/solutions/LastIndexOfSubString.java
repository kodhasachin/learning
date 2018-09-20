package solutions;

import java.util.ArrayList;

public class LastIndexOfSubString {

//	public static int last_index_of_sub_string(String parent, String sub_str)
//	{
//		int j=0, index=0, final_idx=-1;
//		for(int i=0; i<parent.length(); i++)
//		{
//			index=i;
//			while(j<sub_str.length() && i<parent.length() && parent.charAt(i)==sub_str.charAt(j))
//			{
//				j++;
//				i++;
//			}
//			if(j==sub_str.length())
//				final_idx=index;
//			else
//				index=0;
//			j=0;
//		}
//		return final_idx;
//	}
	
	public static int last_index_of_sub_string(String parent, String sub_str)
	{
		ArrayList<Integer> list = new ArrayList<Integer>();
		int j=0;
		for(int i=0; i<parent.length(); i++)
		{
			if(i<parent.length() && j<sub_str.length() && parent.charAt(i)==sub_str.charAt(j))
			{
				j++;
			}
			else
				j=0;
			
			if(j==sub_str.length())
				list.add(i-j+1);
			
			
		}
		if(list.size()==0)
			return -1;
		else
		{
			System.out.println("Resultant list is: "+list.toString());
			return list.get(list.size()-1);
		}
	}

	public static void main(String[] args) {
		String parent = "sacghinacg";
		String sub_str = "acg";
		System.out.println("Parent String is: "+ parent);
		System.out.println("Sub String is: "+ sub_str);
		System.out.println("First Index of substring in parent string is: "+last_index_of_sub_string(parent, sub_str));

	}
}
