package abstraction;

public class ContractorEmpolyee extends Employee {
	
	public ContractorEmpolyee(String name, int wadges)
	{
		super(name, wadges);
	}
	
	public int calculateSalary()
	{
		return get_paymentperhour()*8;
	}

	public static void main(String[] args) {
		ContractorEmpolyee ce = new ContractorEmpolyee("Kannan Contract", 20);
		System.out.println("Kannan Contract Salary is: "+ce.calculateSalary());

	}

}
