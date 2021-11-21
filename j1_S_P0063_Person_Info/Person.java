package j1_S_P0063_Person_Info;

public class Person {
	private String name;
	private String address;
	private double salary;
	
	/**
	 * @param name
	 * @param address
	 * @param salary
	 */
	protected Person(String name, String address, double salary) {
		super();
		this.name = name;
		this.address = address;
		//validate
		this.salary = salary;
	}
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public double getSalary() {
		return salary;
	}


	public void setSalary(double salary) {
		this.salary = salary;
	}


	//display person info
	protected void displayPersonInfo(Person person) {
		System.out.println(person);
	}
	

	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("Name: " +this.name+
							"\nAddress: "+this.address+
							"\nSalary: "+this.salary);
	}

}
