package fr.candidature.application;

import fr.candidature.domain.UserEventPublisher;
import fr.candidature.domain.event.UserDeletedEvent;
import fr.candidature.domain.model.User;
import fr.candidature.domain.model.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserEventPublisher userEventPublisher;

    public UserService(UserRepository userRepository, UserEventPublisher userEventPublisher) {
        this.userRepository = userRepository;
        this.userEventPublisher = userEventPublisher;
    }

    public UUID create(User user) {
        return userRepository.create(user);
    }

    @Transactional
    public void activate(UUID id) {
        User user = userRepository.findById(id).orElseThrow();
        userEventPublisher.publish(user.activate());
    }

    @Transactional
    public void disable(UUID id) {
        User user = userRepository.findById(id).orElseThrow();
        userEventPublisher.publish(user.desactivate());
    }

    @Transactional
    public void delete(UUID id) {
        userRepository.findById(id).orElseThrow();
        userRepository.deleteById(id);

        userEventPublisher.publish(new UserDeletedEvent(id));
    }

}
