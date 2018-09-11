package solutions;

public class StringPatternValidation {
	
	public static boolean is_valid_string(String str)
	{
		int count = 0;
		for(int i=0; i<str.length(); i++)
		{
			if(str.charAt(i)=='a')
				count++;
			else
				count--;
			if(count<0)
				return false;
		}
		if(count==0)
			return true;
		else
			return false;
		
	}

	public static void main(String[] args) {
		String input = "aaaabbbbabb";
		System.out.println("Input String is: "+input);
		System.out.println("Is this valid string: "+is_valid_string(input));

	}

}
