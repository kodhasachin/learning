package solutions;

public class ReverseANumber {
	
	public static int reverse_a_number(int a)
	{
		int val = 0;
		while(a/10>0)
		{
			val = val*10+a%10;
			a=a/10;
		}
		return val*10+a%10;
	}

	public static void main(String[] args) {
		int a = 123;
		System.out.println("Reverse of number "+a+" is:"+reverse_a_number(a));

	}

}
