package fr.candidature.domain.event;

import java.util.UUID;

public class UserActivatedEvent extends UserEvent {

    public UserActivatedEvent(UUID userId) {
        super(userId);
    }

    @Override
    public String getEventType() {
        return "USER_ACTIVATED";
    }
}
