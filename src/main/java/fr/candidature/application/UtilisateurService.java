package fr.candidature.application;

import fr.candidature.domain.Utilisateur;
import fr.candidature.domain.UtilisateurRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UtilisateurService {

    UtilisateurRepository utilisateurRepository;

    public UtilisateurService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    public UUID creer(Utilisateur utilisateur) {
        return utilisateurRepository.creer(utilisateur);
    }
}
