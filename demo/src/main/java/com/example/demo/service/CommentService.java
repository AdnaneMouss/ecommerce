package com.example.demo.service;
import com.example.demo.modele.Comment;
import com.example.demo.repository.*;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    public CommentService(CommentRepository CommentRepository) {
        this.CommentRepository = CommentRepository;
    }
    public CommentService() {}

    @Autowired
    private CommentRepository CommentRepository;

    public List<Comment> getAllComments() {
        return CommentRepository.findAll();
    }

    public Optional<Comment> getCommentById(Long id) {
        return CommentRepository.findById(id);
    }

    public boolean createComment(Comment Comment) {
        boolean res=false;
        try{
            CommentRepository.save(Comment);
            res=true;
        }
        catch(Exception e){
            System.out.println(e);
        }
        return res;
    }

    public boolean updateComment(int id, Comment updatedComment) {
        boolean res=false;
        try{
            CommentRepository.save(updatedComment);
            updatedComment.setId((long) id);
            res=true;
        }
        catch(Exception e){
            System.out.println(e);
        }
        return res;
    }

    public boolean deleteComment(int id) {
        boolean res;
        if(CommentRepository.existsById((long) id)) {
            res=false;
        }
        else{
            CommentRepository.deleteById((long) id);
            res=true;
        }
        return res;
    }
}
