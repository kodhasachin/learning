package practice;

public class InstanceOfOperator {
	
//	public static Object add(Object obj1, Object obj2)
//	{
//		if(obj1 instanceof String)
//			return ((String) obj1).concat((String)obj2);
//		if(obj2 instanceof String)
//			return ((String) obj1).concat((String)obj2);
//		else
//			return obj1+obj2;
//		
//		
//	}

	public static void main(String[] args) {
		Object obj = "sachin";
		String str = "kodha";
		
		if(obj instanceof String)
			System.out.println("Object type is string ");

	}

}
