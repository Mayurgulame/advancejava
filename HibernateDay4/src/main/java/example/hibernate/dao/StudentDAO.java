package example.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import example.hibernate.entity.Course;
import example.hibernate.entity.Student;

public class StudentDAO {

    private static SessionFactory factory;

    static {
        factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();
    }

    public static void addStudent(String firstName, String lastName, String email) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            Student newStudent = new Student(firstName, lastName, email);
            session.save(newStudent);
            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }

    public static Student getStudent(int studentId) {
        Session session = factory.openSession();
        try {
            return session.get(Student.class, studentId);
        } finally {
            session.close();
        }
    }

    public static void updateStudent(int studentId, String firstName, String lastName, String email) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            Student student = session.get(Student.class, studentId);
            if (student != null) {
                student.setFirstName(firstName);
                student.setLastName(lastName);
                student.setEmail(email);
                session.update(student);
                session.getTransaction().commit();
            }
        } finally {
            session.close();
        }
    }

    public static void deleteStudent(int studentId) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            Student student = session.get(Student.class, studentId);
            if (student != null) {
                session.delete(student);
                session.getTransaction().commit();
            }
        } finally {
            session.close();
        }
    }

    public static void addCourseToStudent(int studentId, String courseName) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            Student student = session.get(Student.class, studentId);
            if (student != null) {
                Course newCourse = new Course(courseName);
                newCourse.addStudent(student);
                session.save(newCourse);
                session.getTransaction().commit();
            }
        } finally {
            session.close();
        }
    }
}
