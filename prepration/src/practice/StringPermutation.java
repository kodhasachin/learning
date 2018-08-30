package practice;

public class StringPermutation {
	
	public static void string_permutation(String str, int s, int e)
	{
		if(s==e)
			System.out.println(str);
		else
		{
			for(int i=s; i<str.length(); i++)
			{
				str = swap(str, s, i);
				string_permutation(str, s+1, e);
				str = swap(str, s ,i);
			}
		}
		
	}
	
	
	public static String swap(String str, int i, int j)
	{
		char [] arr = str.toCharArray();
		char tmp = arr[i];
		arr[i]=arr[j];
		arr[j]=tmp;
		str = String.valueOf(arr);
		return str;
	}

	public static void main(String[] args) {
		String str = "ABC";
		string_permutation(str, 0, 2);

	}

}
