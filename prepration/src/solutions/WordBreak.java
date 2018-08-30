package solutions;

import java.util.HashSet;

public class WordBreak {
	
	public static HashSet<String> dict = new HashSet<String>();
	
	public static boolean is_word_break(String str)
	{
		if(str.length()==0)
			return true;
		for(int i=1; i<=str.length(); i++)
		{
			String sub_str = str.substring(0, i);
			if(dict.contains(sub_str) &&is_word_break(str.substring(i,str.length())))
				return true;
		}
		return false;
		
	}

	
	public static void main(String[] args) {
		
		dict.add("i");
		dict.add("love");
		dict.add("coffee");
		dict.add("monk");
		dict.add("eye");
		dict.add("monkey");
			
		System.out.println("Given dictionary is: "+dict.toString());
		
		String str = "monkeye";
		System.out.println(str+" can be split into dictionary words: "+is_word_break(str));
			
		

	}

}
