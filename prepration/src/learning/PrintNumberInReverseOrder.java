package learning;

import java.util.Arrays;

public class PrintNumberInReverseOrder {
	
	public static void print_number_in_reverse_order(int i)
	{
		while(i/10>0)
		{
			System.out.println(i%10);
			i=i/10;
			
		}
		System.out.println(i%10);
	}
	
	public static void print_number_in_reverse_order_rec(int i)
	{
		if(i/10!=0)
		{
			System.out.println(i%10);
			
			print_number_in_reverse_order_rec(i/10);
		}
		else
			System.out.println(i%10);

	}
	
	public static int sum_of_number(int i)
	{
		int val =0;
		if(i/10==0)
			val=i%10;
		else
		{
			i=(i/10)+(i%10);
			val = val+sum_of_number(i);
		}
		return val;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//print_number_in_reverse_order_rec(867);
		System.out.println("sum is: "+sum_of_number(12345));
		
		

	}

}
