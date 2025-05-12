package fr.candidature.domain.event;

import java.util.UUID;

public class UserDesactivateEvent extends UserEvent {

    public UserDesactivateEvent(UUID userId) {
        super(userId);
    }
}
