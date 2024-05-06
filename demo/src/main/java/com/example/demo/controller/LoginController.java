package com.example.demo.controller;
import java.util.Objects;
import com.example.demo.modele.comptes;
import com.example.demo.service.LoginService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
@RestController
public class LoginController {
    @Autowired
    private LoginService userService;
    @GetMapping("/login1")

    public ModelAndView login() {
        ModelAndView mav = new ModelAndView("login");
        mav.addObject("user", new comptes());
        return mav;
    }
    @PostMapping("/login")
    public String login(@ModelAttribute("user") comptes user ) {
        comptes oauthUser = userService.login(user.getUsername(), user.getPassword());
        System.out.print(oauthUser);
       return "shop";

    }
    @RequestMapping(value = {"/logout"}, method = RequestMethod.POST)
    public String logoutDo(HttpServletRequest request,HttpServletResponse response)
    {
        return "redirect:/login";
    }
}