package polymorphism;

public class OverridingExample extends OverloadingExample {
	
	public static int get_area(int l, int w)
	{
		System.out.println("In overriding function");
		return l*w*2;
	}

	public static void main(String[] args) {
		System.out.println("Double square area is: "+get_area(3, 3));
		System.out.println("Parent class Square area is: "+OverloadingExample.get_area(3, 3));

	}

}
