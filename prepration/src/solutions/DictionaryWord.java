package solutions;

import java.util.HashSet;


public class DictionaryWord {
	public static HashSet<String> dict = new HashSet<String>();
	
	public static void print_dictionary_words(String input)
	{
		for(int i=1; i<=input.length(); i++)
			{
				String str = input.substring(0, i);
				if(dict.contains(str))
				{
					System.out.println(str);
					print_dictionary_words(input.substring(i, input.length()));
				}
					
			}
	}

	public static void main(String[] args) {
		dict.add("is");
		dict.add("hi");
		dict.add("name");
		dict.add("this");
		dict.add("his");
			
		System.out.println("Given dictionary is: "+dict.toString());
		//String str = "thisishisname";
		String str = "ishis";
		System.out.println("Input string is: "+str);
		print_dictionary_words(str);

	}

}
