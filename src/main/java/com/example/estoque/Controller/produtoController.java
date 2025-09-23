package com.example.estoque.Controller;


import com.example.estoque.Service.ProdutoService;
import com.example.estoque.models.Produtos;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class produtoController {

    private final ProdutoService produtoService;
    public produtoController(ProdutoService produtoService){
        this.produtoService = produtoService;
    }

    @GetMapping
    public List<Produtos> ListarProdutos(){
        return produtoService.listaProdutos();
    }

    @GetMapping("/{id}")
    public Produtos buscarProduto(@PathVariable long id){
        return produtoService.buscaProdutoPorId(id);
    }

    @PostMapping
    public Produtos salvar(@RequestBody Produtos produto){
        return produtoService.salvar(produto);
    }

    @PutMapping("/{id}")
    public Produtos atualizarProduto(@PathVariable long id, @RequestBody Produtos produto){
        produto.setId(id);
        return produtoService.salvar(produto);
    }

    @DeleteMapping("/{id}")
    public void apagarProduto(@PathVariable long id){
        produtoService.deletarProduto(id);
    }
}
