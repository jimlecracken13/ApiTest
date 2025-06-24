package com.example.demo.repositorie;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepositorie extends JpaRepository<User, Long> {
    User findByNom(String nom);
}
