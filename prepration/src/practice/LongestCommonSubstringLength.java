package practice;

public class LongestCommonSubstringLength {
	
	public static int longest_common_substring_length(String str1, String str2)
	{
		int[][] result_set = new int[str1.length()+1][str2.length()+1];
		for(int i=1; i<=str1.length(); i++)
		{
			for(int j=1; j<=str2.length(); j++)
			{
				if(str1.charAt(i-1)==str2.charAt(j-1))
					result_set[i][j]=result_set[i-1][j-1]+1;
				else
					result_set[i][j]=Math.max(result_set[i-1][j], result_set[i][j-1]);
			}
		}
		return result_set[str1.length()][str2.length()];
	}

	public static void main(String[] args) {
		String str1 = "abcd";
		String str2 = "abd";
		System.out.println("String1 is: "+str1);
		System.out.println("String2 is: "+str2);
		System.out.println("Length of Longest Common Subsequence is: "+longest_common_substring_length(str1, str2));

	}

}
