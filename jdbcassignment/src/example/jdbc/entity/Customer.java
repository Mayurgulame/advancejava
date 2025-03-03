package example.jdbc.entity;

public class Customer {
private String customerId;
private String name;
private String email;
private int age;
public Customer() {
	super();
	// TODO Auto-generated constructor stub
}
public Customer(String customerId, String name, String email, int age) {
	super();
	this.customerId = customerId;
	this.name = name;
	this.email = email;
	this.age = age;
}
public String getCustomerId() {
	return customerId;
}
public void setCustomerId(String customerId) {
	this.customerId = customerId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
@Override
public String toString() {
	return "Customer [customerId=" + customerId + ", name=" + name + ", email=" + email + ", age=" + age + "]";
}

}
