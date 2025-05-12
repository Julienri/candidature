package fr.candidature.domain;

import java.util.UUID;

public interface UtilisateurRepository {

    UUID creer(Utilisateur utilisateur);
    void modifier(Utilisateur utilisateur);
    void supprimer(Utilisateur utilisateur);
}
