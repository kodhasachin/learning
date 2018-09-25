package solutions;

public class JavaPlusOperator {
	
	public static Object java_plus_operator(Object obj1, Object obj2)
	{
		Object result = new Object();
		System.out.println("Type of obj: "+obj1.getClass().getName());
		
		if(obj1 instanceof String || obj2 instanceof String)
		{
			String tmp1 = (String) obj1;
			String tmp2 = (String) obj2;
			result = tmp1.concat(tmp2);
		}
		else
		{
			String type1 = obj1.getClass().getName();
			String type2 = obj2.getClass().getName();
			
			
			
		}
		
	return result;
		
	}

	public static void main(String[] args) {
		
		System.out.println("Result is: "+java_plus_operator(0.8976,2));
		
		

	}

}
