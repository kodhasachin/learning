package solutions;

public class RepeatedCharLength {
	
	public static void longest_repeated_character(String str)
	{
		int count=1, max=1;
		Character curr=null, prev=null;
		for(int i=0; i<str.length()-1; i++)
		{
			if(max<count)
			{
				max=count;
				prev=curr;
			}
			curr = str.charAt(i);
			count=1;
			while((i+1)<str.length() && str.charAt(i)==str.charAt(i+1) )
			{
				count++;
				i++;
			}
			
		}
		System.out.println("Most repeated character: "+prev+" its freq is: "+max);
		
	}
	

	public static void main(String[] args) {
		String str = "aabbbbcbbbdd";
		System.out.println("Input String is: "+str);
		System.out.println("Longest repeated character with its length is: ");
		longest_repeated_character(str);

	}

}
