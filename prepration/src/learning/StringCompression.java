package learning;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class StringCompression {
	
	public static String str_compression(String str)
	{
		StringBuilder res = new StringBuilder();
		char [] arr = str.toCharArray();
		int count = 0;
		
		for(int i=0; i<str.length(); i++)
		{
			count++;
			if(i+1>=str.length() || arr[i]!=arr[i+1] )
			{
				res.append(arr[i]);
				res.append(count);
				count = 0;
				
			}
			
		}
		
		return res.length()<str.length()? res.toString():str;	
	}

	public static void main(String[] args) {
		System.out.println("Compressed String is: "+str_compression("abcccccc"));

	}

}
