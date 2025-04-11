package Model;

import java.time.LocalDateTime;

public class Loan {
    private Integer bookId;
    private Book book;
    private Customer customer;
    private LocalDateTime loanDate;
    private LocalDateTime returnDate;

    public Loan(Book book, Customer customer, LocalDateTime loanDate) {
        this.book = book;
        this.customer = customer;
        this.loanDate = loanDate;
    }

    public Book getBook() {
        return book;
    }

    public Customer getCustomer() {
        return customer;
    }

    public LocalDateTime getLoanDate() {
        return loanDate;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public LocalDateTime setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
        return returnDate;
    }

}
