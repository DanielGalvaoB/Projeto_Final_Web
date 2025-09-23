package com.example.estoque.models;


import com.example.estoque.enums.funcionario;
import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;
    private String email;
    private String senha;

    @Enumerated(EnumType.STRING)
    private funcionario perfil;
    public Usuario() {}

    public Usuario(String nome, String email, String senha, funcionario perfil) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.perfil = perfil;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public funcionario getPerfil() {
        return perfil;
    }

    public void setPerfil(funcionario perfil) {
        this.perfil = perfil;
    }


}
