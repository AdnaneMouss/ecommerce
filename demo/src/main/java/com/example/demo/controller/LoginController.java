package com.example.demo.controller;
import java.util.Objects;
import com.example.demo.modele.Comptes;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.example.demo.service.Loginservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
@Controller
@RequestMapping("/user")

public class LoginController {
    @Autowired
    private Loginservice userService;
    @GetMapping("/login1")
    public ModelAndView Comptes() {
        ModelAndView mav = new ModelAndView("login");
        mav.addObject("user", new Comptes());
        return mav;
    }
    @PostMapping("/login")
    public String Comptes(@RequestParam String username, @RequestParam String pwd ) {
        Comptes oauthUser = userService.login(username,pwd);
        if(Objects.nonNull(oauthUser))
        {
            return "";
        } else {
            return "";
        }
    }
    public boolean Compte(Comptes user){
        boolean res = false;
        Comptes oauthUser = userService.login(user.getUsername(), user.getPassword());
        if(Objects.nonNull(oauthUser))
        {
            res=true;
        } else {
            res=false;
        }
        return res;
    }
    @RequestMapping(value = {"/logout"}, method = RequestMethod.POST)
    public String logoutDo(HttpServletRequest request,HttpServletResponse response)
    {
        return "redirect:/login";
    }
}