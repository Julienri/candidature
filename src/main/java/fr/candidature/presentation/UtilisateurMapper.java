package fr.candidature.presentation;

import fr.candidature.domain.Utilisateur;

import java.util.UUID;

public class UtilisateurMapper {

    public static Utilisateur toUtilisateur(UtilisateurDto dto) {
        return new Utilisateur(UUID.randomUUID(), dto.nom(), dto.prenom(), dto.email());
    }
}
