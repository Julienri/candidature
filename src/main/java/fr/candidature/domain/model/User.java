package fr.candidature.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;
import java.util.UUID;

@Entity
public class User {

    @Id
    private UUID id;
    private String name;
    private String firstName;
    private String email;
    private Boolean active;

    public User(UUID id, String name, String firstName, String email, Boolean active) {
        this.id = id;
        this.name = name;
        this.firstName = firstName;
        this.email = email;
        this.active = active;
    }

    // for persist
    public User() {
    }

    public void activate() {
        this.active = true;
    }

    public void deactivate() {
        this.active = false;
    }


    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getEmail() {
        return email;
    }

    public Boolean getActive() {
        return active;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User that = (User) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
