package Basics;

public class Person implements Comparable {
	protected String name;
	protected String lastName;
	protected int age;
	
	public Person(String name, String lastName, int age) {
		this.name = name;
		this.lastName = lastName;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	

	@Override
	public boolean equals(Object obj) {
		Person p = (Person)obj;
		if ((name.equals(p.getName())) && 
				(lastName.equals(p.getLastName())) &&
				(age == p.getAge())) 
			return true;
		return false;
	}
	
	@Override
	public int compareTo(Object o) {
		Person p = (Person)o;
		/*
		int order;
		
		order = name.compareTo(p.getName());
		if (order != 0) return order;
		
		order = lastName.compareTo(p.getLastName());
		return order;
		*/
		
		if (age > p.getAge()) return 1;
		if (age < p.getAge()) return -1;
		return lastName.compareTo(p.getLastName());
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", lastName=" + lastName + ", age=" + age + "]";
	}	
	
}
