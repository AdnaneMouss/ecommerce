package com.example.demo.repository;

import com.example.demo.modele.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    int countByUserType(String userType);
    int countByCategory(String category);
}
