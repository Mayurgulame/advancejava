package example.hibernate.dao;

public class AddCourseForStudentDemo {

    public static void main(String[] args) {
        int studentId = 2;
        StudentDAO.addCourseToStudent(studentId, "Devops");
        StudentDAO.addCourseToStudent(studentId, "Cloud Computing");
        System.out.println("Courses added successfully!");
    }
}
