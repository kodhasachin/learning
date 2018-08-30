package solutions;

public class ReverseEachWord {
	
	public static String reverse_each_word(String str)
	{
		int j=0;
		StringBuilder res = new StringBuilder();
		for(int i=0; i<str.length(); i++)
		{
			if(str.charAt(i)==' '|| i==str.length()-1)
			{
				for(int k=i; k>=j; k--)
					res.append(str.charAt(k));
				j=i;
			}
				
		}
		return res.toString();
	}

	public static void main(String[] args) {
		String str = "my name is sachin";
		System.out.println("Input String: "+str);
		System.out.println("Output String: "+reverse_each_word(str));

	}

}
