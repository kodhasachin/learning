package learning;

public class ReverseWords {
	
	public static String reverse_word(String str)
	{
		int j=0;
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<str.length(); i++)
		{
			if(str.charAt(i)==' '|| i==str.length()-1)
			{
				if(i==str.length()-1)
					sb.append(' ');
				for(int k=i; k>=j; k--)
				{
					
					sb.append(str.charAt(k));
				}
			
					//sb.append(' ');
					j=i+1;
				
						
				
				
			}
			
		}
		return sb.toString();
	}
	
	
	

	public static void main(String[] args) {
		System.out.println("Reversed String is: "+ reverse_word("my name is sachin kodha saxena"));

	}

}
