package fr.candidature.domain.event;

import java.util.UUID;

public class UserCreatedEvent extends UserEvent {

    private final String name;
    private final String firstName;
    private final String email;

    @Override
    public String getEventType() {
        return "USER_CREATED";
    }

    public UserCreatedEvent(UUID userId, String name, String firstName, String email) {
        super(userId);
        this.name = name;
        this.firstName = firstName;
        this.email = email;
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
}
