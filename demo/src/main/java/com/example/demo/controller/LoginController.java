package com.example.demo.controller;
import java.util.Objects;
import com.example.demo.modele.Comptes;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.example.demo.service.Loginservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
@Controller
@RequestMapping("/user")
public class LoginController {
    @Autowired
    private Loginservice userService;

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        // Perform login logic here (e.g., validate credentials)
        if (userService.authenticate(username,password)) {
            System.out.println("REUSSI");
            return "loginPage";
        } else {
            System.out.println("no");
            model.addAttribute("error", "Invalid username or password");
            return "";
        }
    }
    private boolean isValidUser(String username, String password) {
        // Replace this with actual authentication logic (e.g., querying a database)
        return username.equals("admin") && password.equals("admin123");
    }
    @RequestMapping(value = {"/logout"}, method = RequestMethod.POST)
    public String logoutDo(HttpServletRequest request,HttpServletResponse response)
    {
        return "redirect:/login";
    }
}