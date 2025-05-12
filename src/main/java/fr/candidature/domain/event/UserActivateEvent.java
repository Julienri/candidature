package fr.candidature.domain.event;

import java.util.UUID;

public class UserActivateEvent extends UserEvent {

    public UserActivateEvent(UUID userId) {
        super(userId);
    }
}
