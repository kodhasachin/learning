package polymorphism;

public class OverloadingExample {
	
	public static int get_area(int l, int w)
	{
		return l*w;
	}
	
	
	public static int get_area(int l, int w, int h)
	{
		return l*w*h;
	}

	public static void main(String[] args) {
		System.out.println("Square area is: "+get_area(3, 3));
		System.out.println("Cube area is: "+get_area(3, 3, 3));
		

	}

}
