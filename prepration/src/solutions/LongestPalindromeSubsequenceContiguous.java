package solutions;

public class LongestPalindromeSubsequenceContiguous {
	
	public static int longest_contiguous_palindrome_subsequence_length(String str, int first, int last)
	{
		if(first==last)
			return 1;
		if(str.charAt(first)==str.charAt(last)&&first+1==last)
			return 2;
		
		int len=0;
		if(str.charAt(first)==str.charAt(last))
			{
				len = len+longest_contiguous_palindrome_subsequence_length(str,first+1,last-1)+2;
			}
			else{
				len=Math.max(longest_contiguous_palindrome_subsequence_length(str,first,last-1),
				longest_contiguous_palindrome_subsequence_length(str,first+1,last));
			}
		return len;	
	}

	public static void main(String[] args) {
		
		//String str = "banana";
		String str = "GEEKSFORGEEKS";
		System.out.println("Input String is: "+str);
		System.out.println("Length of Longest Palindrome contiguous subsequence is: "
		+longest_contiguous_palindrome_subsequence_length(str, 0, 12));

	}

}
