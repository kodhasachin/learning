package solutions;

public class MergeStrings {

	public static String merge_strings(String s1, String s2)
	{
		char[] arr = new char[s1.length()+s2.length()];
		int i=0, j=0, k=0;
		while(i<s1.length() && j<s2.length())
		{
			arr[k]=s1.charAt(i);
			i++;
			k++;
			arr[k]=s2.charAt(j);
			j++;
			k++;
		}
		while(i<s1.length())
		{
			arr[k]=s1.charAt(i);
			i++;
			k++;
		}
		while(j<s2.length())
		{
			arr[k]=s2.charAt(j);
			i++;
			k++;
		}
		return String.valueOf(arr);
		
	}
	public static void main(String[] args) {
		String str1 = "sachin";
		String str2 = "kodha";
		
		System.out.println("Merged String is: "+merge_strings(str1, str2));

	}

}
