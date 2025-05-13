package fr.candidature.domain.exception;

public class UserAlreadyExistsException extends RuntimeException {

    public UserAlreadyExistsException(String email) {
         super(String.format("L'utilisateur ayant comme adresse mail %s existe déjà", email));
     }
}
