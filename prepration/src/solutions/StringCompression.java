package solutions;

public class StringCompression {
	
	public static String string_compression(String str)
	{
		StringBuilder sb = new StringBuilder();
		char[] a = str.toCharArray();
		int count=1;
		for(int i=0; i<str.length()-1;i++)
		{
			sb.append(a[i]);
			while(i+1!=a.length&&a[i]==a[i+1])
			{
				i++;
				
				count++;
			}
			sb.append(count);
			count=1;
		}
		
		return sb.toString();
		
	}

	public static void main(String[] args) {
		String str = "aabbbccccc";
		System.out.println("Given String is: "+str);
		System.out.println("Compressed String is: "+string_compression(str));

	}

}
