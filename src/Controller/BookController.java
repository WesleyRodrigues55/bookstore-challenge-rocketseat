package Controller;

import Model.Author;
import Model.Book;
import Utils.Utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BookController {

    public List<Book> setBooks(List<Author> authors) {
        List<Book> books = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            LocalDate generateRandomDate = new Utils().generateRandomDate();

            Book book = new Book(
                    i,
                    "Title " + i,
                    authors.get(i-1),
                    true,
                    generateRandomDate,
                    generateRandomDate
            );
            books.add(book);
        }

        return books;
    }

    public void showBooksAvailable(List<Book> availableBooks) {
        boolean anyAvailable = availableBooks.stream().anyMatch(Book::getIsAvailable);

        if (!anyAvailable) {
            System.out.println("No books available at the moment.\n");
            return;
        }

        availableBooks.stream()
            .filter(Book::getIsAvailable)
            .forEach((book) -> {
                    System.out.println("Id: " + book.getId());
                    System.out.println("Title: " + book.getTitle());
                    System.out.println("Author: " + book.getAuthor().getName());
                    System.out.println("Is Available: " + book.getIsAvailable());
                    System.out.println("Registration Date: " + book.getRegistrationDate());
                    System.out.println("Update Date: " + book.getUpdateDate());

                    System.out.println("\n");
            });
    }


}
