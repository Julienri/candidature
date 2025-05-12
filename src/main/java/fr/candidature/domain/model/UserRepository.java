package fr.candidature.domain.model;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository {

    void deleteById(UUID id);

    Optional<User> findById(UUID id);

    Optional<User> findByEmail(String email);

    void save(User user);
}
