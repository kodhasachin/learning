package solutions;

public class PalindromeString {
	
	public static boolean is_palindrome(String str)
	{
		int i=0, j=str.length()-1;
		while(i<=j)
		{
			if(str.charAt(i)!=str.charAt(j))
				return false;
			else
			{
				i++;
				j--;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String str = "dallad";
		System.out.println("Is '"+str+"' palindrome: "+is_palindrome(str));

	}

}
