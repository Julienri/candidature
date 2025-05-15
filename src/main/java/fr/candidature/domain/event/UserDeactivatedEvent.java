package fr.candidature.domain.event;

import java.util.UUID;

public class UserDeactivatedEvent extends UserEvent {

    public UserDeactivatedEvent(UUID userId) {
        super(userId);
    }

    @Override
    public String getEventType() {
        return "USER_DEACTIVATED";
    }
}
