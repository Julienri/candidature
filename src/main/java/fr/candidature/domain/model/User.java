package fr.candidature.domain.model;

import fr.candidature.domain.event.UserActivateEvent;
import fr.candidature.domain.event.UserDesactivateEvent;
import fr.candidature.domain.event.UserEvent;
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

    public UserEvent activate() {
        this.active = true;
        return new UserActivateEvent(id);
    }

    public UserEvent desactivate() {
        this.active = false;
        return new UserDesactivateEvent(id);
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
