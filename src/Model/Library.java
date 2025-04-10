package Model;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books = new ArrayList<>();
    private List<Author> authors = new ArrayList<>();
    private List<Loan> loans = new ArrayList<>();
    private List<Customer> customers = new ArrayList<>();

    public Library(List<Book> books, List<Author> authors, List<Customer> customers) {
        this.books = books;
        this.authors = authors;
        this.customers = customers;
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public List<Loan> getLoans() {
        return loans;
    }

    public void setLoan(Loan loan) {
        this.loans.add(loan);
    }


}
