package com.example.estoque.Service;

import com.example.estoque.models.Produtos;
import com.example.estoque.models.Usuario;
import com.example.estoque.models.movimentacaoProduto;
import com.example.estoque.repository.MovimetacaoRepository;
import com.example.estoque.repository.produtoRepository;
import org.springframework.stereotype.Service;
import com.example.estoque.enums.movimentacao;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class movimentacaoService {
    private final MovimetacaoRepository movimetacaoRepository;
    private final produtoRepository produtoRepository;

    public movimentacaoService(MovimetacaoRepository movimetacaoRepository, produtoRepository produtoRepository) {
        this.movimetacaoRepository = movimetacaoRepository;
        this.produtoRepository = produtoRepository;
    }

    public List<movimentacaoProduto> listaMovimentacoes(){
        return this.movimetacaoRepository.findAll();
    }

    public List<movimentacaoProduto> listaMovimentacoesPorUser(Usuario usuario){
        return this.movimetacaoRepository.findByUsuario(usuario);
    }



    public movimentacaoProduto registrarMovimentacao(Usuario usuario, Produtos produto, int quantidade, movimentacao movimentacao){
        if(movimentacao == movimentacao.SAIDA){
            if (produto.getQuantidade() < quantidade){
                throw new IllegalArgumentException("Estoque insuficiente");
            }
            produto.removerProduto(quantidade);
        }else if(movimentacao == movimentacao.ENTRADA){
            produto.addProduto(quantidade);
        }
        produtoRepository.save(produto);

        movimentacaoProduto mov = new movimentacaoProduto(
                LocalDateTime.now(),
                usuario,
                produto,
                quantidade,
                movimentacao
        );
        return movimetacaoRepository.save(mov);
    }
}
