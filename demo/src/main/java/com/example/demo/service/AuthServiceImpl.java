package com.example.demo.service;
import com.example.demo.modele.comptes;
import com.example.demo.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public AuthServiceImpl(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public String login(String username, String password) {
        comptes user = userRepository.findByUsername(username);
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            // Générer et retourner un token JWT
            // Exemple simplifié pour la démonstration
            return "votre_token_jwt";
        }
        return null;
    }

    @Override
    public void logout() {
        // Implémentez la logique de déconnexion si nécessaire
    }
}
