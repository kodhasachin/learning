package inheritance;

public class PrivateConstructorChild extends PrivateConstructor {
	
	

	public static void main(String[] args) {
		
		PrivateConstructorChild pc = new PrivateConstructorChild();
		System.out.println("Age is: "+pc.get_age());
	}

}
