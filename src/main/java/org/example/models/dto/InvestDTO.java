package org.example.models.dto;

import java.time.Month;

public class InvestDTO {
    public Long id;
    public String name;
    public Long value;
    public String month_ref;

    public String getMonth_ref() {
        return month_ref;
    }

    public InvestDTO(Long id, String name, Long value, String month_ref) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.month_ref = month_ref;
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
