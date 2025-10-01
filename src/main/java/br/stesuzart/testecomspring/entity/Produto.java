package br.stesuzart.testecomspring.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Produto {
    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private String descricao;
    private Long unidades;

    public Produto(long id, String nome, String descricao, long unidades) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.unidades = unidades;
    }

    public Produto() {

    }

    public Long getId() {
        return id;
    }
    public Long getUnidades() {
        return unidades;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getNome() {
        return nome;
    }
}