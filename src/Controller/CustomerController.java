package Controller;

import Model.Customer;
import Model.Library;
import Utils.Utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerController {

    public List<Customer> createCustomer() {
        List<Customer> customers = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            LocalDate generateRandomDate = new Utils().generateRandomDate();
            Customer customer = new Customer(i, "Customer " + i, generateRandomDate, "customer"+i+"@gmail.com");
            customers.add(customer);
        }

        return customers;
    }

    public Optional<Customer> isCustomerExists(String inputNameUser, Library library) {
        String checkNameInListCustomer = inputNameUser.toLowerCase();
        List<Customer> customers = library.getCustomers();

        return customers
                .stream()
                .filter(customer -> customer.getName().toLowerCase().equals(checkNameInListCustomer))
                .findFirst();
    }
}
