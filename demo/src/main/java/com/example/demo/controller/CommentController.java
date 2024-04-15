package com.example.demo.controller;

import com.example.demo.modele.Comment;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

public interface CommentController {
    List<Comment> getAllComments();
    Optional<Comment> getCommentById(Long id);

    @Transactional
    Comment createComment(Comment comment);

    void deleteComment(Long id);
}
