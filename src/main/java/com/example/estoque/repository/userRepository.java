package com.example.estoque.repository;

import com.example.estoque.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface userRepository extends JpaRepository<Usuario,Long> {
    Optional<Usuario> findByEmail(String Email);

}
