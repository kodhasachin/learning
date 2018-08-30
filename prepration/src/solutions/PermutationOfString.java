package solutions;

public class PermutationOfString {
	
	public static void permute(String str, int s, int e)
	{
		if(s==e)
			System.out.println(str);
		else
		{
			for(int i=s; i<str.length(); i++)
			{
				str = swap(str,s,i);
				permute(str,s+1,e);
				str = swap(str,s,i);
			}
		}
	}
	
	public static String swap(String str, int s, int k)
	{
		char[] tmp_arr = str.toCharArray();
		char tmp = tmp_arr[s];
		tmp_arr[s]=tmp_arr[k];
		tmp_arr[k]=tmp;
		return String.valueOf(tmp_arr);
		
	}

	public static void main(String[] args) {
		String str = "ABC";
		System.out.println("All permutation of string '"+str+"' are:");
		permute(str,0,2);
	}

}
