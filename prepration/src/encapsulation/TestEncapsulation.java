package encapsulation;

public class TestEncapsulation {

	public static void main(String[] args) {
		EncapsulationExample ee = new EncapsulationExample(41, 15000, "Sachin Kodha");
		
		System.out.println("Employee age is: "+ee.get_age());
		System.out.println("Employee salary is: "+ee.get_salary());
		System.out.println("Employee Name is: "+ee.get_empName());
		
		ee.set_age(42);
		ee.set_salary(150000);
		ee.set_name("S Kodha");
		
		System.out.println("Employee age is: "+ee.get_age());
		System.out.println("Employee salary is: "+ee.get_salary());
		System.out.println("Employee Name is: "+ee.get_empName());
	}

}
