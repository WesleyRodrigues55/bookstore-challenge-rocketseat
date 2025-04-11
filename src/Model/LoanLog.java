package Model;

import java.time.LocalDateTime;

public class LoanLog {
    private String message;
    private LocalDateTime timestamp;
    private Loan loan;
    private Customer customer;
    private Book book;

    public LoanLog(String message, LocalDateTime timestamp, Loan loan, Customer customer, Book book) {
        this.message = message;
        this.timestamp = timestamp;
        this.loan = loan;
        this.customer = customer;
        this.book = book;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public Book getBook() {
        return book;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Loan getLoan() {
        return loan;
    }

}
