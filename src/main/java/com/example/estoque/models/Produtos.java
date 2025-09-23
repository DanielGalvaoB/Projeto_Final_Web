package com.example.estoque.models;


import com.example.estoque.enums.tipoProduto;
import jakarta.persistence.*;

@Entity
@Table(name = "produtos")
public class Produtos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;
    private String descricao;
    private double preco;
    private int quantidade;

    @Enumerated(EnumType.STRING)
    private tipoProduto tipoProduto;

    public Produtos() {

    }

    public Produtos(String nome, String descricao, double preco, int quantidade, tipoProduto tipoProduto) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidade = quantidade;
        this.tipoProduto = tipoProduto;
    }

    public void addProduto(int quantidade){
        this.quantidade += quantidade;
    }

    public void removerProduto(int quantidade){
        if (quantidade <= this.quantidade) {
            this.quantidade -= quantidade;
        }
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public tipoProduto getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(tipoProduto tipoProduto) {
        this.tipoProduto = tipoProduto;
    }
}
