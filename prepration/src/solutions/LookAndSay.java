package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class LookAndSay {
	
	public static void look_and_say(int num, int level)
	{
		int[] input = store_digits(num);
		int counter = 1;
		while(counter<=level)
		{
			input = print_look_and_say(input);
			System.out.println(Arrays.toString(input));
			counter++;
		}
		
	}
	
	public static int[] print_look_and_say(int[] input) 
	{
		ArrayList<Integer> res = new ArrayList<Integer>();
		for(int i=0; i<input.length; i++)
		{
			int count=1;
			while(i+1<input.length && input[i]==input[i+1])
			{
				count++;
				i++;
			}
			res.add(count);
			res.add(input[i]);
		}
		int[] output = new int[res.size()];
		int j=0;
		for(int i:res)
		{
			output[j]=i;
			j++;
		}
			
		return output;
	}
	
	public static int[] store_digits(int number)
	{
		Stack<Integer> stk = new Stack<Integer>();
		while(number/10!=0)
		{
			stk.push(number%10);
			number = number/10;
		}
		stk.push(number%10);
		int[] digits = new int[stk.size()];
		int i=0;
		while(!stk.isEmpty())
		{
			digits[i]=stk.pop();
			i++;
		}
		System.out.println("Digits array is:"+Arrays.toString(digits));
		return digits;
	}

	public static void main(String[] args) {
		int number = 123;
		int level = 3;
		look_and_say(number, level);
		

	}

}
