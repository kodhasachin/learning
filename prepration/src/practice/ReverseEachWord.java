package practice;

public class ReverseEachWord {
	
	public static String reverse_each_word(String str)
	{
		char[] a = str.toCharArray();
		int j=0;
		for(int i=0; i<a.length; i++)
		{
			
			if(a[i]==' ' || i==a.length-1)
			{
				for(int k=i ; k>=(i-j)/2; k--)
				{
					char c = a[j];
					a[j]=a[k];
					a[k]=c;
				}
				j=i;
				
			}
		}
		return String.valueOf(a);
	}
	
	public static String reverse_each_word_using_stringbuilder(String str)
	{
		StringBuilder sb = new StringBuilder();
		int j=0;
		for(int i=0; i<str.length(); i++)
		{
			if(str.charAt(i)==' ' || i==str.length()-1)
			{
				for(int k=i; k>=j; k--)
					sb.append(str.charAt(k));
				j=i;
			}
			//sb.append(' ');
			
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		String str = "my name is sachin kodha";
		System.out.println("Input String is: "+str);
		System.out.println("String with each word reversed is: "+reverse_each_word(str));
		System.out.println("Using SB: String with each word reversed is: "+reverse_each_word_using_stringbuilder(str));

	}

}
