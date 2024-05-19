package com.example.demo.service;

import com.example.demo.modele.Comment;
import com.example.demo.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    private final CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public CommentService() {
        this.commentRepository = null; // Default constructor for some frameworks
    }

    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    public Optional<Comment> getCommentById(Long id) {
        return commentRepository.findById(id);
    }

    public boolean createComment(Comment comment) {
        boolean res = false;
        try {
            commentRepository.save(comment);
            res = true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return res;
    }

    public boolean updateComment(int id, Comment updatedComment) {
        boolean res = false;
        try {
            updatedComment.setId((long) id);
            commentRepository.save(updatedComment);
            res = true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return res;
    }

    public boolean deleteComment(int id) {
        boolean res;
        if (!commentRepository.existsById((long) id)) {
            res = false;
        } else {
            commentRepository.deleteById((long) id);
            res = true;
        }
        return res;
    }

    public int countComments() {
        return (int) commentRepository.count();
    }

    public int countByUserType(String userType) {
        return commentRepository.countByUserType(userType);
    }

    public int countByCategory(String category) {
        return commentRepository.countByCategory(category);
    }
}
