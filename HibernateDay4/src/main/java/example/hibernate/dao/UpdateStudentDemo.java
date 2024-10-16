package example.hibernate.dao;

public class UpdateStudentDemo {

    public static void main(String[] args) {
        int studentId = 1;
        StudentDAO.updateStudent(studentId, "John", "Doe Updated", "john.doe.updated@example.com");
        System.out.println("Student updated successfully!");
    }
}
