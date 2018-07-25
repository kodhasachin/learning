package inheritance;

public class ParentA {
	
	int p_age;
	int p_salary;
	String p_name;
	
    void set_age(int age)
    {
    	p_age = age;
    	
    }
    
    void set_salary(int salary)
    {
    	p_salary = salary;
    	
    }
    
    void set_name(String name)
    {
    	p_name = name;
    	
    }
    
    int get_age()
    {
    	return p_age;
    }
    
    int get_salary()
    {
    	return p_salary;
    }
    
    String get_name()
    {
    	return p_name;
    }
}
