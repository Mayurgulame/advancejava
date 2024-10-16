package example.hibernate.dao;

import example.hibernate.entity.Student;

public class ReadStudentDemo {

    public static void main(String[] args) {
        int studentId = 1;
        Student student = StudentDAO.getStudent(studentId);
        if (student != null) {
            System.out.println("Student details: " + student);
            System.out.println("Courses: " + student.getCourses());
        } else {
            System.out.println("Student with ID " + studentId + " not found.");
        }
    }
}
