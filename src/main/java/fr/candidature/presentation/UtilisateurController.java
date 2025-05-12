package fr.candidature.presentation;

import fr.candidature.application.UtilisateurService;
import fr.candidature.domain.Utilisateur;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UtilisateurController {

    private final UtilisateurService utilisateurService;

    public UtilisateurController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @PostMapping
    public ResponseEntity<UUID> creer(@RequestBody UtilisateurDto utilisateurDto) {
        Utilisateur utilisateur = UtilisateurMapper.toUtilisateur(utilisateurDto);
        UUID uuid = utilisateurService.creer(utilisateur);
        return ResponseEntity.ok(uuid);
    }
}
