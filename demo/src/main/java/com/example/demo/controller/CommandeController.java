package com.example.demo.controller;

import com.example.demo.modele.categorie;
import com.example.demo.service.CategorieService;
import com.example.demo.service.CommandeService;
import com.example.demo.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/categorie")
public class CommandeController {

    @Autowired
    private CommandeService commandeService;

}
