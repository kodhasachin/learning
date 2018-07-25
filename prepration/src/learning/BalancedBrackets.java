package learning;

import java.util.Stack;

public class BalancedBrackets {
	
	public static boolean is_balanaced(String str)
	{
		Stack<Character> mystack = new Stack<Character>();
		
		char[] arr = str.toCharArray();
		for(Character c: arr)
		{
			if(c=='{')
				mystack.push('}');
			else if(c=='[')
				mystack.push(']');
			else if(c=='(')
				mystack.push(')');
			else if(mystack.isEmpty()||mystack.pop()!=c)
				return false;
		}
		return mystack.isEmpty();
				
		
	}

	public static void main(String[] args) {
		System.out.println("Is Balanaced: "+is_balanaced("{[()]}"));

	}

}
