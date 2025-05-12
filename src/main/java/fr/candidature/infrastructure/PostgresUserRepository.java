package fr.candidature.infrastructure;

import fr.candidature.domain.model.User;
import fr.candidature.domain.model.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class PostgresUserRepository implements UserRepository {

    @Override
    public UUID create(User user) {
        return user.getId();
    }

    @Override
    public Optional<User> findById(UUID id) {
        return null;
    }

    @Override
    public void deleteById(UUID id) {

    }
}
