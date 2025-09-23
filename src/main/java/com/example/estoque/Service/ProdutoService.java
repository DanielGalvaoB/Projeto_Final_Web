package com.example.estoque.Service;


import com.example.estoque.models.Produtos;
import com.example.estoque.repository.produtoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private final produtoRepository produtoRepository;
    public ProdutoService(produtoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<Produtos>  listaProdutos(){
        return this.produtoRepository.findAll();
    }

    public Produtos buscaProdutoPorId(long id){
        return produtoRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Produto Não Encontrado"));
    }

    public Produtos salvar(Produtos produto){
        return produtoRepository.save(produto);
    }

    public void deletarProduto(long id){
        produtoRepository.deleteById(id);
    }
}
