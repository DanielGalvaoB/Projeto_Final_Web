package com.example.estoque.repository;

import com.example.estoque.models.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface produtoRepository extends JpaRepository<Produtos, Long> {
}
