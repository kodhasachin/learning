package encapsulation;

public class EncapsulationExample {
	
	private int age;
	private int salary;
	private String name;
	
	public EncapsulationExample(int newage, int newsalary, String empName)
	{
		age=newage;
		salary=newsalary;
		name=empName;
	}
	
	public void set_age(int newage)
	{
		age=newage;
	}
	
	public void set_salary(int newsalary)
	{
		salary=newsalary;
	}
	
	public void set_name(String emp_name)
	{
		name=emp_name;
	}
	
	public int get_age()
	{
		return age;
	}
	
	public int get_salary()
	{
		return salary;
	}
	
	public String get_empName()
	{
		return name;
	}

	public static void main(String[] args) {
		EncapsulationExample ee = new EncapsulationExample(50,2000, "Paarth Kodha");
		
//		ee.set_age(40);
//		ee.set_name("Sachin Kodha");
//		ee.set_salary(1000);
//		
		System.out.println("Employee age is: "+ee.get_age());
		System.out.println("Employee salary is: "+ee.get_salary());
		System.out.println("Employee Name is: "+ee.get_empName());

	}

}
