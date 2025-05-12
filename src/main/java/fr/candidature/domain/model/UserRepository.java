package fr.candidature.domain.model;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository {

    UUID create(User user);

    Optional<User> findById(UUID id);

    void deleteById(UUID id);
}
