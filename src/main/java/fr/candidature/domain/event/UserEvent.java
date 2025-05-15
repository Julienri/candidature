package fr.candidature.domain.event;

import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

public abstract class UserEvent {

    private final UUID userId;
    private final Instant time;

    public abstract String getEventType();

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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UserEvent userEvent = (UserEvent) o;
        return Objects.equals(userId, userEvent.userId) && Objects.equals(time, userEvent.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, time);
    }
}
