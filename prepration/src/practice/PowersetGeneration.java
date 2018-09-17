package practice;

public class PowersetGeneration {
	
	public static void powerset_with_recurrsion(String str)
	{
		char[] input = str.toCharArray();
		char[] res = new char[input.length];
		generate_powerset(input, res, 0);
		
	}
	
	public static void generate_powerset(char[] input, char[] res, int i)
	{
		if(i==input.length)
			System.out.println(String.valueOf(res));
		else
		{
			res[i]=' ';
			generate_powerset(input, res, i+1);
			res[i]=input[i];
			generate_powerset(input, res, i+1);
		}
		
	}
	
	public static void powerset(String str)
	{
		int total_powerset = (int) Math.pow(2, str.length());
		for(int i=0; i<total_powerset; i++)
		{
			for(int j=0; j<str.length(); j++)
			{
				if((i&(1<<j))>0)
					System.out.print(str.charAt(j));
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		String input = "abcd";
		System.out.println("Input String is: "+input);
		//powerset_with_recurrsion(input);
		System.out.println("Powerset without recurrsion:");
		powerset(input);

	}

}
