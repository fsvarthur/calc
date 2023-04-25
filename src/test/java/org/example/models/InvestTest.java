package org.example.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Month;

class InvestTest {
    Invest inv = new Invest(1L,"CDB Itau",1000L);
    @BeforeEach
    void setUp() {
        inv.setMonth_ref(Month.JANUARY);
    }
    @Test
    void getNome() {
        Assertions.assertEquals("CDB Itau", inv.getName());
    }
    @Test
    void getId() {
        Assertions.assertEquals(1L, inv.getId());
    }
    @Test
    void getMonth_ref() {
        Assertions.assertEquals(Month.JANUARY, inv.getMonth_ref());
    }
}