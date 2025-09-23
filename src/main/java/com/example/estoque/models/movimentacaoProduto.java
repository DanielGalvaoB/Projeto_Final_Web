
package com.example.estoque.models;

import java.time.LocalDateTime;

import jakarta.persistence.*;

import com.example.estoque.enums.movimentacao;

@Entity
@Table(name = "movimetacao")
public class movimentacaoProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Enumerated(EnumType.STRING)
    private movimentacao tipoMovimentacao;

    private int quantidade;
    private LocalDateTime data;

    @ManyToOne
    @JoinColumn(name = "userID", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "produtoID",  nullable = false)
    private Produtos produto;


    public movimentacaoProduto(LocalDateTime data, Usuario usuario, Produtos produto, int quantidade, movimentacao tipoMovimentacao) {
        this.data = data;
        this.usuario = usuario;
        this.produto = produto;
        this.quantidade = quantidade;
        this.tipoMovimentacao = tipoMovimentacao;
    }

    public movimentacaoProduto() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public movimentacao getTipoMovimentacao() {
        return tipoMovimentacao;
    }

    public void setTipoMovimentacao(movimentacao tipoMovimentacao) {
        this.tipoMovimentacao = tipoMovimentacao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Produtos getProduto() {
        return produto;
    }

    public void setProduto(Produtos produto) {
        this.produto = produto;
    }
}