package fr.candidature.infrastructure;

import fr.candidature.domain.Utilisateur;
import fr.candidature.domain.UtilisateurRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class PostgresUtilisateurRepository implements UtilisateurRepository {

    @Override
    public void modifier(Utilisateur utilisateur) {
    }

    @Override
    public void supprimer(Utilisateur utilisateur) {
    }

    @Override
    public UUID creer(Utilisateur utilisateur) {
        return utilisateur.getId();
    }
}
