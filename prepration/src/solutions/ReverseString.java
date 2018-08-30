package solutions;

public class ReverseString {
	
	public static String reverse_string(String str)
	{
		if(str.length()==1)
			return str;
		else
			return str.charAt(str.length()-1)+reverse_string(str.substring(0, str.length()-1));
		
	}
	
	public static String reverse_string_using_array(String str)
	{
		char[] a = str.toCharArray();
		int i=0; int j=a.length-1;
		while(i<=j)
		{
			char c = a[i];
			a[i]=a[j];
			a[j]=c;
			i++;
			j--;
		}
		return String.valueOf(a);
	}
	
	public static String reverse_string_using_stringbuilder(String str)
	{
		StringBuilder sb = new StringBuilder();
		for(int i=str.length()-1; i>=0; i--)
			sb.append(str.charAt(i));
		return sb.toString();
	}
	
	public static String reverse_string_using_iteration(String str)
	{
		String reverse = "";
		for(int i=str.length()-1;i>=0; i--)
		{
			reverse = reverse+str.charAt(i);
		}
		return reverse;
	}
	
	public static String reverse_string_using_recurrsion(String str)
	{
		if(str.length()==1)
			return str;
		else
			return str.charAt(str.length()-1)+reverse_string_using_recurrsion(str.substring(0, str.length()-1));
	}

	public static void main(String[] args) {
		
		String str = "kodha";
		System.out.println("Reverse String of '"+str+"' is:"+reverse_string(str));
		System.out.println("Using array-Reverse String of '"+str+"' is:"+reverse_string_using_array(str));
		System.out.println("Using StringBuilder-Reverse String of '"+str+"' is:"+reverse_string_using_stringbuilder(str));
		System.out.println("Using itration-Reverse String of '"+str+"' is:"+reverse_string_using_iteration(str));
		System.out.println("Using recurrsion-Reverse String of '"+str+"' is:"+reverse_string_using_recurrsion(str));

	}

}
