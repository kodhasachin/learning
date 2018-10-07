package solutions;

import java.util.Arrays;

public class LongestCommonSubstring {
	
	public static String longest_common_substring(String str1, String str2)
	{
		String resultant_str = "";
		int[][] res = new int[str1.length()+1][str2.length()+1];
		int max=0, row=0, col=0;
		
		for(int i=1; i<=str1.length(); i++)
		{
			for(int j=1; j<=str2.length(); j++)
			{
				if(str1.charAt(i-1)==str2.charAt(j-1))
					res[i][j]=res[i-1][j-1]+1;
				if(max<res[i][j])
				{
					max=res[i][j];
					row=i;
					col=j;
				}
			}
		}
		System.out.println("Resultant Array is: "+Arrays.deepToString(res));
		System.out.println("Length of Longest common String is: "+max);
		if(max == 0)
			return "No Common string exists";
		else
		{
			for(int i=0; i<row; i++)
			{
				resultant_str=resultant_str+str1.charAt(i);
				
			}
		}
		return resultant_str;
	}

	public static void main(String[] args) {
		
//		String str1 = "GeeksforGeeks";
//		String str2 = "QGeeksuiz";
		String str1 = "abcd";
		String str2 = "ebc";
		
		System.out.println("First String is: "+str1);
		System.out.println("Second String is: "+str2);
		
		System.out.println("Common substring is: "+longest_common_substring(str1, str2));
		
		

	}

}
