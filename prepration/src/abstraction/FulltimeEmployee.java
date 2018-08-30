package abstraction;

public class FulltimeEmployee extends Employee {
	
	public FulltimeEmployee(String name, int wadge)
	{
		super(name, wadge);
	}
	
	public int calculateSalary()
	{
		return get_paymentperhour()*9;
	}

	public static void main(String[] args) {
		FulltimeEmployee fe = new FulltimeEmployee("Sachin Kodha", 30);
		System.out.println("Full time employee Salary: "+ fe.calculateSalary());

	}

}
