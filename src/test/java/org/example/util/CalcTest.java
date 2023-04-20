package org.example.util;

import org.example.models.Invest;
import org.example.models.KeyAnalyzers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Month;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalcTest {
    Invest inv = new Invest();
    Invest inv2 = new Invest();
    KeyAnalyzers ka = new KeyAnalyzers();
    HashMap<String, Invest> hs = new HashMap<>();
    HashMap<String, KeyAnalyzers> hKey = new HashMap<>();
    private Calc calc;
    @BeforeEach
    public void setUp(){
        inv.setMonth_ref(Month.JANUARY);
        inv2.setMonth_ref(Month.APRIL);
        ka.setValue(10.0);

        hKey.put("1",ka);
        hs.put("1",inv);
        hs.put("2",inv2);
    }

    @Test
    public void filterMonth(){
        HashMap<String, Invest> hs2 = Calc.filter(hs, Month.JANUARY);
        hs.remove("2");
        assertEquals(hs.get(String.valueOf(hs.size())).getMonth_ref(), hs2.get("1").getMonth_ref());
        assertEquals(hs.size(), hs2.size());
    }
}