package example.hibernate.dao;

public class InsertStudentDemo {
public static void main(String[] args) {
	StudentDAO.addStudent("vaibhav", "jadhav", "vaibhav@gmail.com");
	System.out.println("inserted succesfully");
}
}
