package inheritance;

public class ChildA extends ParentA {
	
	public void set_name(String name)
	{
		System.out.println("Parent name is: "+super.get_name());
		p_name = name+"_Child";
	}
	
	public void compute_name(String name)
	{
		System.out.println("In child specific function");
		
	}
	

	public static void main(String[] args) {
		ChildA c = new ChildA();
		
		c.set_name("Sachin Kodha");
		c.set_age(30);
		c.set_salary(150);
		System.out.println(c.get_name());
		System.out.println(c.get_age());
		System.out.println(c.get_salary());

	}

}
