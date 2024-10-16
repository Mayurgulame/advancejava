package example.jdbc.main;

import example.jdbc.model.CustomerDAO;
import example.jdbc.dao.CustomerDAOImpl;
import example.jdbc.entity.Customer;
import example.jdbc.model.CustomerNotFoundException;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Instantiate CustomerDAO
        CustomerDAO customerDAO = new CustomerDAOImpl();

        // Create a Scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Main menu loop
        int choice;
        do {
            System.out.println("Menu:");
            System.out.println("1. Add Customer");
            System.out.println("2. Search Customer");
            System.out.println("3. Show Senior Citizen Customers");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Add Customer
                    System.out.print("Enter Customer ID: ");
                    String customerId = scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    Customer newCustomer = new Customer(customerId, name, email, age);
                    customerDAO.addCustomer(newCustomer);
                    System.out.println("Customer added successfully!");
                    break;
                case 2:
                    // Search Customer
                    System.out.print("Enter Customer ID to search: ");
                    String searchId = scanner.nextLine();
                    try {
                        Customer foundCustomer = customerDAO.getCustomerById(searchId);
                        System.out.println("Customer found:");
                        System.out.println(foundCustomer);
                    } catch (CustomerNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    // Show Senior Citizen Customers
                    System.out.println("Senior Citizen Customers:");
                    List<Customer> seniorCitizens = customerDAO.getSeniorCitizenCustomers();
                    for (Customer seniorCitizen : seniorCitizens) {
                        System.out.println(seniorCitizen);
                    }
                    break;
                case 4:
                    // Exit
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        // Close scanner
        scanner.close();
    }
}
