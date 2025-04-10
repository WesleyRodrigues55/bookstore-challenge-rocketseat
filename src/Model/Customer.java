package Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Customer {
    private Integer id;
    private String name;
    private LocalDate birthday;
    private String email;

    public Customer(Integer id, String name, LocalDate birthday, String email) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public String getEmail() {
        return email;
    }
}
