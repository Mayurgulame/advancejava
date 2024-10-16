package example.hibernate.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import example.hibernate.entity.Employee;

public class EmployeeDAO {

    private static SessionFactory factory;

    static {
        try {
            factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static int saveEmployee(Employee e) {
        Session session = factory.openSession();
        session.beginTransaction();
        int id = (int) session.save(e);
        session.getTransaction().commit();
        session.close();
        return id;
    }

    public static void updateEmployee(Employee e) {
        Session session = factory.openSession();
        session.beginTransaction();
        session.update(e);
        session.getTransaction().commit();
        session.close();
    }

    public static void deleteEmployee(int id) {
        Session session = factory.openSession();
        session.beginTransaction();
        Employee employee = session.get(Employee.class, id);
        if (employee != null) {
            session.delete(employee);
        }
        session.getTransaction().commit();
        session.close();
    }

    public static Employee getEmployeeById(int id) {
        Session session = factory.openSession();
        Employee employee = session.get(Employee.class, id);
        session.close();
        return employee;
    }

    @SuppressWarnings("unchecked")
    public static List<Employee> getAllEmployees() {
        Session session = factory.openSession();
        List<Employee> employees = session.createQuery("from Employee").list();
        session.close();
        return employees;
    }
}
