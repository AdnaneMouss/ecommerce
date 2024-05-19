package com.example.demo.controller;

import com.example.demo.modele.Comment;
import com.example.demo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comment")
public class CommentControllerImpl {

    private final CommentService commentService;

    @Autowired
    public CommentControllerImpl(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    public ResponseEntity<List<Comment>> getAllComments() {
        List<Comment> comments = commentService.getAllComments();
        return ResponseEntity.ok(comments);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comment> getCommentById(@PathVariable int id) {
        Optional<Comment> comment = commentService.getCommentById((long) id);
        return comment.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<Boolean> addComment(@RequestBody Comment comment) {
        boolean isCreated = commentService.createComment(comment);
        if (isCreated) {
            return ResponseEntity.status(201).body(true);
        } else {
            return ResponseEntity.status(400).body(false);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Boolean> updateComment(@PathVariable int id, @RequestBody Comment updatedComment) {
        boolean isUpdated = commentService.updateComment(id, updatedComment);
        if (isUpdated) {
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.status(400).body(false);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteComment(@PathVariable int id) {
        boolean isDeleted = commentService.deleteComment(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(404).build();
        }
    }

    @GetMapping("/count")
    public String countComments(Model model) {
        int totalComments = commentService.countComments();
        model.addAttribute("totalComments", totalComments);

        String[] userTypes = {"Admin", "User", "Moderator"};
        for (String userType : userTypes) {
            int count = commentService.countByUserType(userType);
            model.addAttribute(userType + "Count", count);
        }

        String[] categories = {"General", "Feedback", "Issue", "Suggestion"};
        for (String category : categories) {
            int count = commentService.countByCategory(category);
            model.addAttribute(category + "Count", count);
        }

        List<Comment> allComments = commentService.getAllComments();
        model.addAttribute("allComments", allComments);

        return "dashboard_comments";
    }
}
