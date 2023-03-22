package org.example.Models;

import org.junit.Assert;
import org.junit.jupiter.api.*;

import java.time.Month;

class InvestTest {
    Invest inv = new Invest();
    @BeforeEach
    void setUp() {
        inv.setId(1L);
        inv.setNome("CDB Itau");
        inv.setMonth_ref(Month.JANUARY);
        inv.setValue_initial(30000L);
        inv.setValue_final(35000L);
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
    @Test
    void getValue_initial() {
        Assertions.assertEquals(30000L, inv.getValue_initial());
    }
    @Test
    void getValue_final() {
        Assertions.assertEquals(35000L, inv.getValue_final());
    }
}