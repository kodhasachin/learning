package learning;

import java.util.Stack;

public class StackTests {

	public static void main(String[] args) {
		Stack stk = new Stack();
		
		stk.push("Sachin");
		stk.push("Kodha");
		stk.pop();
		stk.pop();
		
		System.out.println(stk.isEmpty());

	}

}
