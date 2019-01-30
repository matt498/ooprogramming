package ex04;

public class Employee {
	public static final double defaultSalary = 1000;
	
	private String name;
	private String lastname;
	private double salary;
	
	public Employee(String name, String lastname, double salary) {
		this.name = name;
		this.lastname = lastname;
		this.salary = Math.max(0.0, salary);;
	}
	
	public Employee(String name, String lastname) {
		this.name = name;
		this.lastname = lastname;
		this.salary = defaultSalary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = Math.max(0.0, salary);
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", lastname=" + lastname + ", salary=" + salary + "]";
	}
	
	
}
