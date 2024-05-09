package com.example.demo.controller;
import com.example.demo.modele.comptes;
import com.example.demo.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/log")
public class UsersController {
    @Autowired
    private UsersService usersService;
    @GetMapping("/login")
    public String authenticateUser(String username, String password, Model model) {
        comptes compte = usersService.authenticate(username, password);
        if (compte != null) {
            model.addAttribute("authenticatedUser", compte);
            return "shop"; // Redirect to success page if authentication succeeds
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "loginPage"; // Redirect back to login page with error message
        }
    }
}
