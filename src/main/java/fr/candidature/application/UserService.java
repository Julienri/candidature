package fr.candidature.application;

import fr.candidature.domain.UserEventPublisher;
import fr.candidature.domain.event.UserActivatedEvent;
import fr.candidature.domain.event.UserCreatedEvent;
import fr.candidature.domain.event.UserDeletedEvent;
import fr.candidature.domain.event.UserDeactivatedEvent;
import fr.candidature.domain.exception.UserAlreadyExistsException;
import fr.candidature.domain.exception.UserNotFoundException;
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

    @Transactional
    public UUID create(User user) {
        userRepository.findByEmail(user.getEmail())
                .ifPresent(existing -> {
                    throw new UserAlreadyExistsException(user.getEmail());
                });
        userRepository.save(user);

        userEventPublisher.publish(new UserCreatedEvent(user.getId(), user.getFirstName(), user.getName(), user.getEmail()));
        return user.getId();
    }

    @Transactional
    public void activate(UUID id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        user.activate();
        userRepository.save(user);

        userEventPublisher.publish(new UserActivatedEvent(user.getId()));
    }

    @Transactional
    public void deactivate(UUID id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        user.deactivate();
        userRepository.save(user);

        userEventPublisher.publish(new UserDeactivatedEvent(user.getId()));
    }

    @Transactional
    public void delete(UUID id) {
        userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        userRepository.deleteById(id);

        userEventPublisher.publish(new UserDeletedEvent(id));
    }

}
