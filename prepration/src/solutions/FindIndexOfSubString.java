package solutions;

import java.util.ArrayList;

public class FindIndexOfSubString {
	
	public static ArrayList<Integer> get_indices(String parent, String sub)
	{
		ArrayList<Integer> result = new ArrayList<Integer>();
		int j=0;
		for(int i=0; i<parent.length(); i++)
		{
			if(j<sub.length() && parent.charAt(i)==sub.charAt(j))
			{
				j++;
				if(j==sub.length())
					result.add(i-j+1);
			}
			else
				j=0;
		}
		return result;
		
	}

	public static void main(String[] args) {
		String parent = "This is my name";
		String sub = "is";
		
		System.out.println("Parent string is: "+parent);
		System.out.println("Sub string is: "+sub);
		System.out.println("Indices of substring into parent are: "+get_indices(parent, sub).toString());

	}

}
