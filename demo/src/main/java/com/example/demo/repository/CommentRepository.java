package com.example.demo.repository;

import com.example.demo.modele.Comment;
import com.example.demo.modele.categorie;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Override
    Optional<Comment> findById(Long aLong);

    @Override
    List<Comment> findAllById(Iterable<Long> longs);

    @Override
    List<Comment> findAll(Sort sort);
}
