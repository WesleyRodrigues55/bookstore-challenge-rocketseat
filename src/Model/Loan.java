package Model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Loan {
    private Integer bookId;
    private Book book;
    private Customer customer;
    private LocalDateTime loanDate;

    public Loan(Book book, Customer customer, LocalDateTime loanDate) {
        this.book = book;
        this.customer = customer;
        this.loanDate = loanDate;
    }

    public Book getBook() {
        return book;
    }

    public String getCustomerName() {
        return customer.getName();
    }

    public Integer getCustomerId() {
        return customer.getId();
    }

    public LocalDateTime getLoanDate() {
        return loanDate;
    }

}
