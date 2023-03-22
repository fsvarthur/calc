package org.example.Models;

import java.time.Month;

public class Invest extends Inv{

    private Long id;
    private String nome;
    private Long value_initial;
    private Long value_final;

    public Invest() {
    }

    public Invest(Long id, String nome, Month month_ref, Long value_initial, Long value_final) {
        this.id = id;
        this.nome = nome;
        this.value_initial = value_initial;
        this.value_final = value_final;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getValue_initial() {
        return value_initial;
    }

    public void setValue_initial(Long value_initial) {
        this.value_initial = value_initial;
    }

    public Long getValue_final() {
        return value_final;
    }

    public void setValue_final(Long value_final) {
        this.value_final = value_final;
    }
}
