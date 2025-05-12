package fr.candidature.domain.event;

import java.util.UUID;

public class UserCreatedEvent extends UserEvent {

    private final String name;
    private final String firstName;
    private final String email;

    public UserCreatedEvent(UUID userId, String name, String firstName, String email) {
        super(userId);
        this.name = name;
        this.firstName = firstName;
        this.email = email;
    }
}
