package org.example.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Month;

class InvestTest {
    Invest inv = new Invest();
    @BeforeEach
    void setUp() {
        inv.setId(1L);
        inv.setNome("CDB Itau");
        inv.setMonth_ref(Month.JANUARY);
    }
    @Test
    void getNome() {
        Assertions.assertEquals("CDB Itau", inv.getNome());
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