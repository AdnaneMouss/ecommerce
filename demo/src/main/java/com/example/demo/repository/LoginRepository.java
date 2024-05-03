package com.example.demo.repository;
import com.example.demo.modele.Comptes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<Comptes, Long>{
    Comptes findByUsername(String username);

    boolean existsByUsernameAndPassword(String username, String password);

}
