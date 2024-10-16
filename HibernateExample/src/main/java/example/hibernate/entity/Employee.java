package example.hibernate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="emp_hibernate")
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private Integer id;
	@Column(name="fname")
private String firstName;
	@Column(name="lname")
private String lastName;
	@Column
private int age;
	@Column
private double salary;
public Employee() {
	super();
	// TODO Auto-generated constructor stub
}
public Employee(Integer id, String firstName, String lastName, int age, double salary) {
	super();
	this.id = id;
	this.firstName = firstName;
	this.lastName = lastName;
	this.age = age;
	this.salary = salary;
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
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
public double getSalary() {
	return salary;
}
public void setSalary(double salary) {
	this.salary = salary;
}
@Override
public String toString() {
	return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", salary="
			+ salary + "]";
}



}
