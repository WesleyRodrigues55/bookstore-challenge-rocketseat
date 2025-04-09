package Model;

import java.time.LocalDate;

public class Author {
    private Integer id;
    private String name;
    private LocalDate birthDate;

    public Author(Integer id, String name, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }
}
