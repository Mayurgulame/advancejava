package com.app.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.bean.Employee;

public class EmployeeDao {

    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver found");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servletdb", "root", "root");
            System.out.println("Connection success");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }



    public static int saveEmp(Employee e) {
        int status = 0;
        Connection con = null;
        PreparedStatement stmt = null;

        try {
            con = getConnection();
            stmt = con.prepareStatement("INSERT INTO emptb(name, password, email, gender, country) VALUES (?, ?, ?, ?, ?)");
            stmt.setString(1, e.getName());
            stmt.setString(2, e.getPassword());
            stmt.setString(3, e.getEmail());
            stmt.setString(4, e.getGender());
            stmt.setString(5, e.getCountry());

            status = stmt.executeUpdate(); // Execute the query and get the number of rows affected
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
		return status;
    }


public static List<Employee> getAllEmployees() {
    List<Employee> employees = new ArrayList<>();
    Connection con = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    try {
        con = getConnection();
        stmt = con.prepareStatement("SELECT * FROM emptb");
        rs = stmt.executeQuery();

        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String password = rs.getString("password");
            String email = rs.getString("email");
            String gender = rs.getString("gender");
            String country = rs.getString("country");

            Employee employee = new Employee(id, name, password, email, gender, country);
            employees.add(employee);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } 

    return employees;
}


public static Employee getEmployeeById(int id) {
    Employee employee = null;
    Connection con = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    try {
        con = getConnection();
        stmt = con.prepareStatement("SELECT * FROM emptb WHERE id=?");
        stmt.setInt(1, id);
        rs = stmt.executeQuery();

        if (rs.next()) {
            String name = rs.getString("name");
            String password = rs.getString("password");
            String email = rs.getString("email");
            String gender = rs.getString("gender");
            String country = rs.getString("country");

            employee = new Employee(id, name, password, email, gender, country);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
	return employee;
}

public static boolean updateEmployee(Employee employee) {
    boolean updated = false;
    Connection con = null;
    PreparedStatement stmt = null;

    try {
        con = getConnection();
        stmt = con.prepareStatement("UPDATE emptb SET name=?, password=?, email=?, gender=?, country=? WHERE id=?");
        stmt.setString(1, employee.getName());
        stmt.setString(2, employee.getPassword());
        stmt.setString(3, employee.getEmail());
        stmt.setString(4, employee.getGender());
        stmt.setString(5, employee.getCountry());
        stmt.setInt(6, employee.getId());

        int rowsAffected = stmt.executeUpdate();
        if (rowsAffected > 0) {
            updated = true;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
	return updated; 
}
public static boolean deleteEmployee(int id) {
    boolean deleted = false;
    Connection con = null;
    PreparedStatement stmt = null;

    try {
        con = getConnection();
        stmt = con.prepareStatement("DELETE FROM emptb WHERE id=?");
        stmt.setInt(1, id);

        int rowsAffected = stmt.executeUpdate();
        if (rowsAffected > 0) {
            deleted = true;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
	return deleted;
}
}








