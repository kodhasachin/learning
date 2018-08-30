package solutions;

import java.util.Arrays;

public class LongestCommonSubsequence {
	
	public static int longest_common_subsequence(String str1, String str2)
	{
		int[][] res = new int[str1.length()+1][str2.length()+1];
		String out = "";
		for(int i=1; i<=str1.length(); i++)
		{
			for(int j=1; j<=str2.length(); j++)
			{
				if(str1.charAt(i-1)==str2.charAt(j-1))
					res[i][j]=res[i-1][j-1]+1;
				else
					res[i][j]=Math.max(res[i][j-1], res[i-1][j]);
				
				if(res[i][j]>out.length())
					out = str1.substring(i-res[i][j], i);
					
			}
		}
		System.out.println("Resultant Array is: "+Arrays.deepToString(res));
		System.out.println("Longest subsequence length is: "+res[str1.length()][str2.length()]);
		System.out.println("Longest subsequence is: "+out);
		return res[str1.length()][str2.length()];
	}

	public static void main(String[] args) {
		String str1 = "bqdrcvefgh";
		String str2 = "abcvdefgh";
		System.out.println("String1 is: "+str1);
		System.out.println("String2 is: "+str2);
		System.out.println("Longest Common Subsequence is: "+longest_common_subsequence(str1, str2));
		

	}

}
