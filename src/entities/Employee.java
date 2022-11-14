package entities;

public class Employee {

	private String Name;
	private String email;
	private Double salary;
	
	public Employee(String name, String email, Double salary) {
		Name = name;
		this.email = email;
		this.salary = salary;
	}
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
}
