package Controller;

import Model.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class BookController {

    public void run() {
        Library library = initializeData();
        mainMenu(library);
    }

    private void mainMenu(Library library) {
        Scanner scanner = new Scanner(System.in);

        String userCmd;
        do {
            System.out.println("Would you like to see the available books?");
            System.out.println("Press 'Y' to continue or 'N' to exit.");
            userCmd = scanner.nextLine().toUpperCase();
            CommandOption selectedOption = CommandOption.fromString(userCmd);

            if (selectedOption == null) {
                System.out.println("Invalid command, please try again.");
                continue;
            }

            switch (selectedOption) {
                case YES:
                    handleBookLoan(library, scanner);
                    break;
                case NO:
                    System.out.println("The program has been finalized...");
                    break;
                default:
                    System.out.println("Invalid command, please try again");
                    break;
            }

        } while (!userCmd.equals("N"));
    }

    private void handleBookLoan(Library library, Scanner scanner) {
        List<Book> availableBooks = library.getBooks();

        showBooksAvailable(availableBooks);

        boolean waitingForValidBook = true;
        do {
            System.out.println("Choose a book by ID from the list above: ");
            String input = scanner.nextLine();

            try {
                int bookId = Integer.parseInt(input);

                Optional<Book> foundBook = availableBooks.stream()
                        .filter(book -> book.getIsAvailable() && book.getId() == bookId)
                        .findFirst();

                if (foundBook.isPresent()) {
                    Book book = foundBook.get();

                    handleUserNameInput(bookId, book, scanner);

                    waitingForValidBook = false;
                } else {
                    System.out.println("Book not found");
                }

            } catch (NumberFormatException e) {
                System.out.println("Please enter an integer.\n");
            }
        } while (waitingForValidBook);
    }

    private Library initializeData() {
        // create authors
        List<Author> authors = setAuthors();

        // create books with reference the authors
        List<Book> books = setBooks(authors);

        // create library with books and authors

        return new Library(books, authors);
    }

    private void handleUserNameInput(Integer bookId, Book book, Scanner scanner) {
        boolean isNameValid = true;
        do {
            System.out.println("Enter your name: ");
            String inputNameUser = scanner.nextLine();

            if (inputNameUser.isEmpty()) {
                System.out.println("Your name is empty");
                continue;
            }

            Loan loan = new Loan(bookId, inputNameUser);

            // defines book as borrowed
            book.setIsAvailable(false);

            System.out.println("Hello " + inputNameUser + ", your loan of book " + book.getTitle() + " has been successfully made!\n");
            isNameValid = false;

        } while (isNameValid);
    }

    private void showBooksAvailable(List<Book> availableBooks) {
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

    private List<Book> setBooks(List<Author> authors) {
        List<Book> books = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            LocalDate randomDate = generateRandomDate();

            Book book = new Book(
                i,
            "Title " + i,
                authors.get(i-1),
                true,
                randomDate,
                randomDate
            );
            books.add(book);
        }

        return books;
    }

    private List<Author> setAuthors() {
        List<Author> authors = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            LocalDate randomDate = generateRandomDate();
            Author author = new Author(i, "Author " + i, randomDate);
            authors.add(author);
        }

        return authors;
    }

    private LocalDate generateRandomDate() {
        LocalDate startDate = LocalDate.of(1900, 1, 1);
        LocalDate endDate = LocalDate.of(2025, 1, 1);

        long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);
        Random random = new Random();
        long randomDays = random.nextInt((int) daysBetween + 1);

        return startDate.plusDays(randomDays);
    }

}
