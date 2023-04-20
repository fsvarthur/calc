package org.example.models.dto;

public class InvestDTO {
    public Long id;
    public String name;
    public Long value;

    public InvestDTO(Long id, String name, Long value) {
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
    public Long getValue() {
        return value;
    }
}
