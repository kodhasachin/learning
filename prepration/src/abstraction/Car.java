package abstraction;

public class Car implements Vehicle {
	
	int speed;
	int gear;
	
	public void change_gear(int gear)
	{
		this.gear=gear;
	}
	
	public void speed_up(int increment)
	{
		speed = speed+increment;
	}
	
	public void apply_brake(int decrement)
	{
		speed = speed-decrement;
	}
	
	public void present_state()
	{
		System.out.println("Car Present state is - Speed: "+speed+ " and gear: "+gear);
	}

	public static void main(String[] args) {
		Car c = new Car();
		c.change_gear(2);
		c.speed_up(10);
		c.apply_brake(2);
		c.present_state();
		
		                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            
	}

}
