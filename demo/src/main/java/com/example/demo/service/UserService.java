package com.example.demo.service;
import com.example.demo.modele.comptes;
import com.example.demo.repository.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
@Service
public class UserService {
    @Autowired
    private CompteRepository userRepository;
    public void saveUser(comptes user) {
        user.setPassword(hashPassword(user.getPassword()));
        userRepository.save(user);
    }
    public comptes findByUsername(String username, String password) {
        return userRepository.findByUsername(username);
    }
    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedPassword = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedPassword) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
