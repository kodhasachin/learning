package abstraction;

public abstract class Employee {
	private String name;
	private int paymentperhour;
	public abstract int calculateSalary();
	public Employee(String emp_name, int wadges)
	{
		name=emp_name;
		paymentperhour=wadges;
	}
	
	public void set_name(String emp_name)
	{
		name=emp_name;
	}
	
	public void set_paymentperhour(int wadges)
	{
		paymentperhour=wadges;
	}
	
	public String get_name()
	{
		return name;
	}
	public int get_paymentperhour()
	{
		return paymentperhour;
	}

}
