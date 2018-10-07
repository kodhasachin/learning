package practice;

import java.util.Arrays;

public class LongestCommonSubstringLength {
	
	public static int longest_common_substring_length(String str1, String str2)
	{
		String out = "";
		int[][] res = new int[str1.length()+1][str2.length()+1];
		for(int i=1; i<=str1.length(); i++)
		{
			for(int j=1; j<=str2.length(); j++)
			{
				if(str1.charAt(i-1)==str2.charAt(j-1))
				{
					res[i][j]=res[i-1][j-1]+1;
					out=out+str1.charAt(i-1);
				}
				else
				{
					if(res[i-1][j]>res[i][j-1])
					{
						res[i][j] = res[i-1][j];
						out=out+str1.charAt(i-1);
					}
					else 
					{
						res[i][j] = res[i][j-1];
						out=out+str1.charAt(i);
					}
				
				}
					
			}
		}
		System.out.println("Resultant SubSequence is: "+ out);
		return res[str1.length()][str2.length()];
	}

	public static void main(String[] args) {
		String str1 = "abcd";
		String str2 = "acd";
		System.out.println("String1 is: "+str1);
		System.out.println("String2 is: "+str2);
		System.out.println("Length of Longest Common Subsequence is: "+longest_common_substring_length(str1, str2));

	}

}
