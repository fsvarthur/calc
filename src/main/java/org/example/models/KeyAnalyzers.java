package org.example.models;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "Keys")
public class KeyAnalyzers extends Inv implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private double value;

    public KeyAnalyzers() {
    }

    public KeyAnalyzers(Long id, String name, double value) {
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

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
