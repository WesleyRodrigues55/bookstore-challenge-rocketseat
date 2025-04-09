package Model;

import java.time.LocalDate;

public class Book {
    private Integer id;
    private String title;
    private Author author;
    private Boolean isAvailable;
    private LocalDate registrationDate;
    private LocalDate updateDate;

    public Book(
            Integer id,
            String title,
            Author author,
            Boolean isAvailable,
            LocalDate registrationDate,
            LocalDate updateDate
    ) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isAvailable = isAvailable;
        this.registrationDate = registrationDate;
        this.updateDate = updateDate;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public Boolean getIsAvailable() {
        return isAvailable;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public LocalDate getUpdateDate() {
        return updateDate;
    }

    public Boolean setIsAvailable(Boolean isAvailable) {
        return this.isAvailable = isAvailable;
    }

}
