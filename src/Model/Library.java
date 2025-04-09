package Model;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books = new ArrayList<>();
    private List<Author> authors = new ArrayList<>();
    private List<Loan> loans = new ArrayList<>();


    public Library(List<Book> books, List<Author> authors) {
        this.books = books;
        this.authors = authors;
    }

    public List<Book> getBooks() {
        return books;
    }

}
