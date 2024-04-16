package com.example.demo.controller;

import com.example.demo.modele.Comment;
import com.example.demo.modele.comptes;
import com.example.demo.service.CommentService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/Comment")
public class CommentControllerImpl {

    @Autowired
    private CommentService dao;

    @GetMapping
    public List<Comment> getAllAccs() {
        return dao.getAllComments();
    }

    @GetMapping("/{id}")
    public Comment getAccById(@PathVariable int id) {
        Optional<Comment> c = dao.getCommentById((long)id);
        return c.orElse(null);
    }

    @PostMapping("/addProduct")
    public boolean addAcc(@RequestBody Comment c) {
        return dao.createComment(c);
    }

    @PutMapping("/{id}")
    public boolean updateAcc(@PathVariable int id, @RequestBody Comment updatedCom) {
        return dao.updateComment(id, updatedCom);
    }

    @DeleteMapping("/{id}")
    public boolean deleteAcc(@PathVariable int id) {
        return dao.deleteComment(id);
    }
}
