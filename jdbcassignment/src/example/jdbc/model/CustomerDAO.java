package example.jdbc.model;

import java.util.List;

import example.jdbc.entity.Customer;

public interface CustomerDAO {
    void addCustomer(Customer customer);
    Customer getCustomerById(String customerId) throws CustomerNotFoundException;
    List<Customer> getSeniorCitizenCustomers();
}
