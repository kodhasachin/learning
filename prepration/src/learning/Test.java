package learning;

public class Test {
	
	public static String reverse_str(String str)
	{   
		if(str.length()==1)
			return str;
		else
		{
			//tmp = str.substring(0,tmp.length()-1);
			return str.charAt(str.length()-1)+reverse_str(str.substring(0,str.length()-1));
		}
	}
	
	
	public static void main(String[] args) {
		
		System.out.println("Reversed String is: "+reverse_str("sachin"));
		
		String str = "Kodha";
		System.out.println("Result is: "+str.substring(0, str.length()-1));
		
		
		

	}

}
