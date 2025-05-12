package fr.candidature.domain.exception;

import java.util.UUID;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(UUID id) {
        super(String.format("Aucun utilisateur trouvé avec l'id : %s.", id));
    }
}
