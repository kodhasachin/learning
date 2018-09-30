package solutions;

public class PerfectNumber {
	
	public static int perfect_number(int n)
	{
		int required_digit = 10-digit_sum(n);
		return n*10+required_digit;
	}
	
	public static int digit_sum(int n)
	{
		int sum = 0;
		while(n/10!=0)
		{
			sum = sum+n%10;
			n=n/10;
		}
		return sum+n%10;
	}

	public static void main(String[] args) {
		
		int given_int = 322;
		System.out.println("Given integer is: "+given_int);
		
		System.out.println("n-th perfect number is: "+perfect_number(given_int));

	}

}
