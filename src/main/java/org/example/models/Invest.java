package org.example.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "investment")
public class Invest extends Inv implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private Long value;

    public Invest() {
    }

    public Invest(Long id, String nome, Long value) {
        this.id = id;
        this.nome = nome;
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }
}
