package learning;

import java.util.ArrayList;

public class ReverseDigits {
	
	public  ArrayList<Integer> list = new ArrayList<Integer>();
	int i = 0;
	public  void reverse_digit(int n)
	{
		
		if(n/10!=0)
		{
			list.add(n%10);
			
			reverse_digit(n/10);
			
		}
		else
			list.add(n%10);
	}
	
	public static int reverse_digit_itr(int n)
	{
		int out = 0;
		while(n>0)
		{
			out = out*10+n%10;
			n=n/10;
		}
		return out;
	}
	public static int out=0;
	public static void reverse_digit_rec(int n)
	{
		if(n>10)
		{
			out = out*10+n%10;
			reverse_digit_rec(n/10);
		}
		else
			out = out*10+n%10;
	}
	public void construct_number()
	{
		StringBuilder sb = new StringBuilder();
		for (int i:list)
			sb.append(i);
		System.out.println("Number is: "+Integer.parseInt(sb.toString()));
	}
	
	public int sum_of_digits(int n)
	{
		int val = 0;
		while(n/10!=0)
		{
			n=n/10+n%10;
			
		}
		return n;
	}
	
	public int sum_of_digits_rec(int n)
	{
		return n/10==0?n%10:sum_of_digits_rec(n/10+n%10);
	}

	public static void main(String[] args) {
		ReverseDigits rd = new ReverseDigits();
//		rd.reverse_digit(54345643);
//		System.out.println("Reversed number is"+rd.list.toString());
//        rd.construct_number();
       System.out.println("Reversed Number of 221 is: "+reverse_digit_itr(200));
        reverse_digit_rec(200);
        System.out.println("Reverse is: "+out);
//        
//        System.out.println("Sum of digits 865 is: "+rd.sum_of_digits_rec(123));
	}

}
