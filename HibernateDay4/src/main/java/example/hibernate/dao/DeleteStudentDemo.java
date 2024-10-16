package example.hibernate.dao;

public class DeleteStudentDemo {

    public static void main(String[] args) {
        int studentId = 1;
        StudentDAO.deleteStudent(studentId);
        System.out.println("Student deleted successfully!");
    }
}
