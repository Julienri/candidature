package fr.candidature.infrastructure;

import fr.candidature.domain.UserEventPublisher;
import fr.candidature.domain.event.UserEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaUserEventPublisher implements UserEventPublisher {

    private static final Logger LOG = LoggerFactory.getLogger(KafkaUserEventPublisher.class);

    private static final String TOPIC = "push.user";

    private final KafkaTemplate<String, UserEvent> kafkaTemplate;

    public KafkaUserEventPublisher(KafkaTemplate<String, UserEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void publish(UserEvent userEvent) {
        String key = userEvent.getClass().getSimpleName();
        kafkaTemplate.send(TOPIC, key, userEvent);
        LOG.info("Événement publié : [{}] {}", key, userEvent);
    }
}
