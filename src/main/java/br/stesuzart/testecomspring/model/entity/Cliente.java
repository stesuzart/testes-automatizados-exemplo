package br.stesuzart.testecomspring.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Cliente {

    @Id
    @GeneratedValue
    private Long id;

    private String nome;
}
