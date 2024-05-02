package com.example.demo.repository;
import com.example.demo.modele.Login;
import com.example.demo.modele.comptes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<comptes, Long>{
    Login findByUsernameAndPassword(String username, String password);

}
