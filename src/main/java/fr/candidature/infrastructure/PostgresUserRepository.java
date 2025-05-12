package fr.candidature.infrastructure;

import fr.candidature.domain.model.User;
import fr.candidature.domain.model.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class PostgresUserRepository implements UserRepository {

    @Override
    public void save(User user) {
    }

    @Override
    public Optional<User> findById(UUID id) {
        return null;
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public void deleteById(UUID id) {

    }
}
