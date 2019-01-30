package ex04;


/**
 * Create a class Employee including three private instance variables:
 * firstName (String), 
 * lastName (String) 
 * salary (double). 
 * 
 * The class must have a constructor for initializing the three instance 
 * variables. Provide a set and a get method for each instance variable. 
 * If salary is not positive, set it to 0.0. 
 * 
 * The class must have a second constructor (overloading) setting only first name
 * and last name. In this case, the salary must be set to a default value (1000),
 * taken from a static variable.
 * 
 * Write a test application demonstrating the class Employee’s capabilities. 
 * Create two Employee objects and display each object’s salary. 
 * Then give each Employee a 10% raise and display each Employee’s salary again.
 * 
 * Remember! Getters, Setters, Constructors and toString methods can be automatically
 * created with Eclipse (see Source Menu).
 * 
 * @author Nicola Bicocchi
 *
 */
public class TestApp {
	public static void main(String[] args) {
		Employee e1 = new Employee("Mario", "Rossi", 2000.0);
		Employee e2 = new Employee("Luca", "Bianchi", 1600.0);
		
		System.out.println(e1);
		System.out.println(e2);
		
		e1.setSalary(e1.getSalary() * 1.1);
		e2.setSalary(e2.getSalary() * 1.1);
		
		System.out.println(e1);
		System.out.println(e2);
	}
}
