package learning;

import java.util.HashSet;

public class WordBreak {
	
	public static HashSet<String> dict = new HashSet<String>();
	
	
	public static boolean word_break(String str)
	{
		if(str.length()==0)
			return true;
		
		for(int i=1; i<=str.length(); i++)
			{
				
				if(dict.contains(str.substring(0, i)) && word_break(str.substring(i,str.length())))
					return true;
			}
			return false;
			
		
		
	}

	public static void main(String[] args) {
		
		dict.add("i");
		dict.add("love");
		dict.add("coffee");
		dict.add("eye");
		dict.add("monk");
		dict.add("monkey");
		
	    System.out.println("Given Dictionary is as: "+dict.toString());
	    System.out.println("Valid Word Break: "+word_break("ilovecoffee"));
	}

}