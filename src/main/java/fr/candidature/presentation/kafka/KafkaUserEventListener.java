package fr.candidature.presentation.kafka;

import fr.candidature.domain.event.UserActivatedEvent;
import fr.candidature.domain.event.UserCreatedEvent;
import fr.candidature.domain.event.UserDeactivatedEvent;
import fr.candidature.domain.event.UserDeletedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@KafkaListener(topics = "push.user", groupId = "user-group")
public class KafkaUserEventListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaUserEventListener.class);

    public KafkaUserEventListener() {
    }

    @KafkaHandler
    public void handleUserCreated(UserCreatedEvent event) {
        LOGGER.info("User created: {}", event);
        // traitement spécifique UserCreatedEvent
    }

    @KafkaHandler
    public void handleUserActivated(UserActivatedEvent event) {
        LOGGER.info("User activated: {}", event);
        // traitement spécifique UserActivatedEvent
    }

    @KafkaHandler
    public void handleUserDeactivated(UserDeactivatedEvent event) {
        LOGGER.info("User deactivated: {}", event);
        // traitement spécifique UserDeactivatedEvent
    }

    @KafkaHandler
    public void handleUserDeleted(UserDeletedEvent event) {
        LOGGER.info("User deleted: {}", event);
        // traitement spécifique UserDeletedEvent
    }

    @KafkaHandler(isDefault = true)
    public void handleDefault(Object event) {
        LOGGER.warn("Event inconnu reçu : {}", event);
    }
}
