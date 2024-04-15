package com.example.demo.controller;

import com.example.demo.modele.Comment;
import com.example.demo.service.ICommentDAO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentControllerImpl implements CommentController {

    private final ICommentDAO commentDAO;


    @Autowired
    public CommentControllerImpl(ICommentDAO commentDAO) {
        this.commentDAO = commentDAO;
    }

    @Override
    public List<Comment> getAllComments() {
        return commentDAO.getAllComments();
    }

    @Override
    public Optional<Comment> getCommentById(Long id) {
        return commentDAO.getCommentById(id);
    }

    @Override
    @Transactional
    public Comment createComment(Comment comment) {
        return commentDAO.createComment(comment);
    }

    @Override
    @Transactional
    public void deleteComment(Long id) {
        commentDAO.deleteComment(id);
    }
}
