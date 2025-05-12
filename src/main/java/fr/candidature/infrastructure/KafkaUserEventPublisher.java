package fr.candidature.infrastructure;

import fr.candidature.domain.UserEventPublisher;
import fr.candidature.domain.event.UserEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaUserEventPublisher implements UserEventPublisher {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaUserEventPublisher(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void publish(UserEvent userEvent) {

    }
}
