package org.example.models;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "Invest")
public class Invest extends Inv implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Long value;

    public Invest() {
    }

    public Invest(Long id, String name, Long value) {
        this.id = id;
        this.name = name;
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }
}
