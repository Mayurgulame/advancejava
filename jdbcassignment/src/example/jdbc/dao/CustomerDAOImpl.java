package example.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import example.jdbc.entity.Customer;
import example.jdbc.model.CustomerDAO;
import example.jdbc.model.CustomerNotFoundException;

public class CustomerDAOImpl implements CustomerDAO {
    // JDBC connection parameters
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/servletdb?allowPublicKeyRetrieval=true&useSSL=false";
    private static final String JDBC_USERNAME = "root";
    private static final String JDBC_PASSWORD = "root";

    // SQL queries
    private static final String ADD_CUSTOMER_QUERY = "INSERT INTO customers (customerId, name, email, age) VALUES (?, ?, ?, ?)";
    private static final String GET_CUSTOMER_BY_ID_QUERY = "SELECT * FROM customers WHERE customerId = ?";
    private static final String GET_SENIOR_CITIZEN_CUSTOMERS_QUERY = "SELECT * FROM customers WHERE age >= 65";

    @Override
    public void addCustomer(Customer customer) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(ADD_CUSTOMER_QUERY)) {
            statement.setString(1, customer.getCustomerId());
            statement.setString(2, customer.getName());
            statement.setString(3, customer.getEmail());
            statement.setInt(4, customer.getAge());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Handle or log exception
        }
    }

    @Override
    public Customer getCustomerById(String customerId) throws CustomerNotFoundException {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(GET_CUSTOMER_BY_ID_QUERY)) {
            statement.setString(1, customerId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return extractCustomerFromResultSet(resultSet);
                } else {
                    throw new CustomerNotFoundException();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle or log exception
            throw new CustomerNotFoundException();
        }
    }

    @Override
    public List<Customer> getSeniorCitizenCustomers() {
        List<Customer> seniorCitizenCustomers = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(GET_SENIOR_CITIZEN_CUSTOMERS_QUERY);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                seniorCitizenCustomers.add(extractCustomerFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle or log exception
        }
        return seniorCitizenCustomers;
    }

    private Customer extractCustomerFromResultSet(ResultSet resultSet) throws SQLException {
        Customer customer = new Customer();
        customer.setCustomerId(resultSet.getString("customerId"));
        customer.setName(resultSet.getString("name"));
        customer.setEmail(resultSet.getString("email"));
        customer.setAge(resultSet.getInt("age"));
        return customer;
    }
}
