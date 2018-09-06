package solutions;

import java.util.Arrays;

public class LongestCommonSubsequence {
	
	public static int length_longest_common_subsequence(String str1, String str2)
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
		//System.out.println("Longest substring is: "+out);
		return res[str1.length()][str2.length()];
	}
	
	public static void print_longest_common_subsequence(String str1, String str2)
	{
		int[][] res = new int[str1.length()+1][str2.length()+1];
		for(int i=1; i<=str1.length(); i++)
		{
			for(int j=1; j<=str2.length(); j++)
			{
				if(str1.charAt(i-1)==str2.charAt(j-1))
					res[i][j]=res[i-1][j-1]+1;
				else
					res[i][j]=Math.max(res[i][j-1], res[i-1][j]);
			}
		}
		int i=str1.length(), j=str2.length();
		int index = res[i][j];
		char[] out = new char[index+1];
		out[index]=' ';
		//int temp = index;
		
		while(i>0 && j>0)
		{
			if(str1.charAt(i-1)==str2.charAt(j-1))
			{
				out[index-1]=str1.charAt(i-1);
				i--;
				j--;
				index--;
			}
			else if(res[i-1][j]>res[i][j-1])
				i--;
			else
				j--;
		}
		System.out.println("Longest common subsequence is: "+String.valueOf(out));
	}

	public static void main(String[] args) {
//		String str1 = "bqdrcvefgh";
//		String str2 = "abcvdefgh";
		String str1 = "abcd";
		String str2 = "acd";
		System.out.println("String1 is: "+str1);
		System.out.println("String2 is: "+str2);
		System.out.println("Length of Longest Common Subsequence is: "+length_longest_common_subsequence(str1, str2));
		print_longest_common_subsequence(str1, str2);

	}

}
