package fr.candidature.domain.event;

import java.util.UUID;

public class UserDeletedEvent extends UserEvent {

    public UserDeletedEvent(UUID userId) {
        super(userId);
    }

    @Override
    public String getEventType() {
        return "USER_DELETED";
    }
}
