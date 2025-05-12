package fr.candidature.domain.event;

import java.time.Instant;
import java.util.UUID;

public abstract class UserEvent {

    private final UUID userId;
    private final Instant time;


    public UserEvent(UUID userId) {
        this.userId = userId;
        this.time = Instant.now();
    }

    public UUID getUserId() {
        return userId;
    }

    public Instant getTime() {
        return time;
    }
}
