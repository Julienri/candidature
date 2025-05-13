package fr.candidature.infrastructure;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    private UUID id;
    private String name;
    private String firstName;
    private String email;
    private Boolean active;

    public UserEntity(UUID id, String name, String firstName, String email, Boolean active) {
        this.id = id;
        this.name = name;
        this.firstName = firstName;
        this.email = email;
        this.active = active;
    }

    public UserEntity() {
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
}
