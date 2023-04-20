package org.example.models;

import java.time.Month;
import java.time.ZonedDateTime;

public class Inv {

    private Month month_ref;
    private ZonedDateTime createdAt;

    public Inv(Month month_ref, ZonedDateTime createdAt) {
        this.month_ref = month_ref;
        this.createdAt = createdAt;
    }

    public Inv() {
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt() {
        this.createdAt = ZonedDateTime.now();
    }

    public Month getMonth_ref() {
        return month_ref;
    }

    public void setMonth_ref(Month month_ref) {
        this.month_ref = month_ref;
    }
}
