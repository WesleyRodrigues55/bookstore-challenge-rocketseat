package Controller;

import Model.*;
import Utils.Utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class LibraryController {
    public void run() {
        Library library = initializeData();
        mainMenu(library);
    }

    private void mainMenu(Library library) {
        Scanner scanner = new Scanner(System.in);

        String userCmd;
        do {
            System.out.println("Would you like to see the available books?");
            System.out.println("Press '1' to see the customers");
            System.out.println("Press '2' to see the loans made");
            System.out.println("Press 'Y' to continue or 'N' to exit.");
            userCmd = scanner.nextLine().toUpperCase();
            CommandOption selectedOption = CommandOption.fromString(userCmd);

            if (selectedOption == null) {
                System.out.println("Invalid command, please try again.");
                continue;
            }

            switch (selectedOption) {
                case LIST_CUSTOMERS:
                    handleCustomers(library);
                    break;
                case LIST_LOANS:
                    handleCustomerLoans(library);
                    break;
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

    private Library initializeData() {
        // create authors
        var author = new AuthorController();
        List<Author> authors = author.createAuthors();

        // create books with reference the authors
        var book = new BookController();
        List<Book> books = book.setBooks(authors);

        // create customers
        var customer = new CustomerController();
        List<Customer> customers = customer.createCustomer();

        // create library with books and authors
        return new Library(books, authors, customers);
    }

    private void handleCustomerLoans(Library library) {
        System.out.println("Customer Loans:");

        List<Loan> loans = library.getLoans();
        var utils = new Utils();

        for (Loan loan : loans) {
            System.out.println("BookId: " + loan.getBook().getTitle());
            System.out.println("Customer name: " + loan.getCustomerName());
            System.out.println("Loan date: " + utils.formatDateTime(loan.getLoanDate()));
            System.out.println();
        }
    }

    private void handleCustomers(Library library) {
        System.out.println("List of all customers:");

        List<Customer> customers = library.getCustomers();
        for (Customer customer : customers) {
            System.out.println("ID: " + customer.getId());
            System.out.println("Name: " + customer.getName());
            System.out.println("Birthday: " + customer.getBirthday());
            System.out.println("E-mail: " + customer.getEmail());
            System.out.println();
        }
    }

    private void handleBookLoan(Library library, Scanner scanner) {
        List<Book> availableBooks = library.getBooks();

        var _book = new BookController();
        _book.showBooksAvailable(availableBooks);

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

                    handleUserNameInput(book, library, scanner);

                    waitingForValidBook = false;
                } else {
                    System.out.println("Book not found");
                }

            } catch (NumberFormatException e) {
                System.out.println("Please enter an integer.\n");
            }
        } while (waitingForValidBook);
    }

    private void handleUserNameInput(Book book, Library library, Scanner scanner) {
        boolean isNameValid = true;
        do {
            System.out.println("Enter your name: ");
            String inputNameUser = scanner.nextLine();

            if (inputNameUser.isEmpty()) {
                System.out.println("Your name is empty");
                continue;
            }

            var _customer = new CustomerController();
            Optional<Customer> customerExists = _customer.isCustomerExists(inputNameUser, library);

            if (customerExists.isPresent()) {
                Customer customer = customerExists.get();

                LocalDateTime loanDate = LocalDateTime.now();
                Loan loan = new Loan(book, customer, loanDate);
                library.setLoan(loan);

                // defines book as borrowed
                book.setIsAvailable(false);

                System.out.println("Hello " + customer.getName() + ", your loan of book " + book.getTitle() + " has been successfully made!\n");
                isNameValid = false;
            } else {
                System.out.println("Customer not found");
            }

        } while (isNameValid);
    }


}
