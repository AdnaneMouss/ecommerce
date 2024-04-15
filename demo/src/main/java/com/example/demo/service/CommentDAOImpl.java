package com.example.demo.service;

import com.example.demo.modele.Comment;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CommentDAOImpl implements ICommentDAO {

    private final EntityManager entityManager;

    @Autowired
    public CommentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<Comment> getAllComments() {
        return entityManager.createQuery("SELECT c FROM Comment c", Comment.class).getResultList();
    }

    @Override
    @Transactional
    public Optional<Comment> getCommentById(Long id) {
        Comment comment = entityManager.find(Comment.class, id);
        return Optional.ofNullable(comment);
    }

    @Override
    public Comment createComment(Comment comment) {
        entityManager.persist(comment);
        return comment;
    }


    @Override
    @Transactional
    public void deleteComment(Long id) {
        Comment comment = entityManager.find(Comment.class, id);
        if (comment != null) {
            entityManager.remove(comment);
        }
    }
}