package com.example.demo.service;


import com.example.demo.modele.Comment;

import java.util.List;
import java.util.Optional;

public interface ICommentDAO {
    List<Comment> getAllComments();
    Optional<Comment> getCommentById(Long id);
    Comment createComment(Comment comment);
    void deleteComment(Long id);


}
