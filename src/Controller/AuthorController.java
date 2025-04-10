package Controller;

import Model.Author;
import Utils.Utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AuthorController {

    public List<Author> createAuthors() {
        List<Author> authors = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            LocalDate generateRandomDate = new Utils().generateRandomDate();
            Author author = new Author(i, "Author " + i, generateRandomDate);
            authors.add(author);
        }

        return authors;
    }
}
