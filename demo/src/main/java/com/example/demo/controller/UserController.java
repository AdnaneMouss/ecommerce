package com.example.demo.controller;
import com.example.demo.modele.comptes;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", new comptes());
        return "login";
    }
    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new comptes());
        return "register";
    }
    @PostMapping("/login")
    public String loginUser(@ModelAttribute("user") comptes user, Model model) {
        boolean isAuthenticated = userService.findByUsername(comptes.getUsername(), user.getPassword());
        if (isAuthenticated) {
            return "redirect:/shop.html";
        } else {
            model.addAttribute("error", "Nom d'utilisateur ou mot de passe incorrect");
            return "login";
        }
    }
}
