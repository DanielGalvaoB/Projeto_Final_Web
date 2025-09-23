package com.example.estoque.Controller;

import com.example.estoque.Service.ProdutoService;
import com.example.estoque.Service.movimentacaoService;
import com.example.estoque.Service.userService;
import com.example.estoque.enums.movimentacao;
import com.example.estoque.models.Produtos;
import com.example.estoque.models.Usuario;
import com.example.estoque.models.movimentacaoProduto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movimentacoes")
public class movControler {

    private final movimentacaoService movimentacaoService;
    private final ProdutoService produtoService;
    private final userService userService;
    public movControler(movimentacaoService movimentacaoService, ProdutoService produtoService
                        ,userService userService) {
        this.movimentacaoService = movimentacaoService;
        this.produtoService = produtoService;
        this.userService = userService;
    }

    @GetMapping
    public List<movimentacaoProduto> listaMovimentacoes(){
        return movimentacaoService.listaMovimentacoes();
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<movimentacaoProduto> listaPorUsuario(@PathVariable Long usuarioId){
        Usuario usuario = userService.buscarPorId(usuarioId);
        return movimentacaoService.listaMovimentacoesPorUser(usuario);
    }


    @PostMapping
    public movimentacaoProduto registrar(
            @RequestParam Long usuarioId,
            @RequestParam Long produtoId,
            @RequestParam int quantidade,
            @RequestParam movimentacao tipo) {

        Usuario usuario = userService.buscarPorId(usuarioId);
        Produtos produto = produtoService.buscaProdutoPorId(produtoId);

        return movimentacaoService.registrarMovimentacao(usuario, produto, quantidade, tipo);
    }

}
