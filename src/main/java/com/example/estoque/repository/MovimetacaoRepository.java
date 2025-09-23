package com.example.estoque.repository;

import com.example.estoque.models.Usuario;
import com.example.estoque.models.movimentacaoProduto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovimetacaoRepository extends JpaRepository<movimentacaoProduto, Long> {
    List<movimentacaoProduto> findByUsuario(Usuario usuario);
}
