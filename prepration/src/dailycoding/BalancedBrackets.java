package dailycoding;

import java.util.Stack;

public class BalancedBrackets {
	
	public static boolean is_balanaced_brackets(String str)
	{
		Stack<Character> stk = new Stack<Character>();
		
		for(int i=0; i<str.length(); i++)
		{
			if(str.charAt(i)=='{')
				stk.push('}');
			else if(str.charAt(i)=='[')
				stk.push(']');
			else if(str.charAt(i)=='(')
				stk.push(')');
			else if(stk.pop()!=str.charAt(i))
				return false;
		}
		if(stk.isEmpty())
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		String str = "{[()]}";
		System.out.println("Input string "+str+" is balanced brackets: "+is_balanaced_brackets(str));

	}

}
