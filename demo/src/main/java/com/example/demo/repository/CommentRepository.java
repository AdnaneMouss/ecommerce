package com.example.demo.repository;

import com.example.demo.modele.Comment;
import com.example.demo.modele.categorie;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CommentRepository extends JpaRepository<Comment, Long> {
}
