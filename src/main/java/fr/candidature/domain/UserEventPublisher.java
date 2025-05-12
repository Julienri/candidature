package fr.candidature.domain;

import fr.candidature.domain.event.UserEvent;

public interface UserEventPublisher {
    void publish(UserEvent userEvent);
}
