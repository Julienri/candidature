package fr.candidature.presentation.controller;

import fr.candidature.domain.model.User;

import java.util.UUID;

public class UserMapper {

    public static User toUtilisateur(UserDto dto) {
        return new User(UUID.randomUUID(), dto.name(), dto.firstName(), dto.email(), null);
    }
}
