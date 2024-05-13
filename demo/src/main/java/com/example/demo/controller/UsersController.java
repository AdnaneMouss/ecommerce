package com.example.demo.controller;
import com.example.demo.modele.comptes;
import com.example.demo.service.UsersService;
import jakarta.servlet.http.HttpSession;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/log")
public class UsersController {
    @Autowired
    private UsersService usersService;
    @GetMapping("/login")
    public String authenticateUser(String username, String password, Model model, HttpSession session) {
        comptes compte = usersService.authenticate(username, password);
        if (compte != null) {
            session.setAttribute("authenticatedUsername", compte.getUsername());
            System.out.println(compte.getUsername());
            System.out.println(session);
            model.addAttribute("authenticatedUser", compte);
            return "shop";
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "loginPage";
        }
    }
    @GetMapping("/comptes/{username}")
    public String obtenirUtilisateurParNom(@PathVariable String nomUtilisateur, Model model) {
        comptes username = usersService.trouverParNomUtilisateur(nomUtilisateur);
        model.addAttribute("utilisateur", username);
        return "";
    }
}
