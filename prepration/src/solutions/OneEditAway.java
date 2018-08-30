package solutions;

public class OneEditAway {
	
	public static boolean is_one_edit_away(String s1, String s2)
	{
		if(Math.abs(s1.length()-s2.length())>1)
			return false;
		
		else if(s1.length()==s2.length())
		{
			int count=0;
			for(int i=0; i<s1.length(); i++)
			{
				if(s1.charAt(i)!=s2.charAt(i))
					count++;
			}
			if(count>1)
				return false;
			else
				return true;
		}
		
		else if(Math.abs(s1.length()-s2.length())==1)
		{
			String first = new String();
			String second = new String();
			if(s1.length()>s2.length())
			{
				first = s1;
				second = s2;
			}
			else
			{
				first = s2;
				second = s1;
			}
				
			int j=0, count=0;
			for(int i=0; i<first.length(); i++)
			{
				if(first.charAt(i)==second.charAt(j))
					j++;
				else
					count++;
			}
			if(count >1)
				return false;
			else
				return true;
		}
		
		else
			return false;
			
	}

	public static void main(String[] args) {
		String str1 = "pale";
		String str2 = "pld";
		
		System.out.println("Strings '"+str1+"' and '"+str2+"' are one edit away: "+is_one_edit_away(str1, str2));

	}

}
