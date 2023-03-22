package org.example.Util;

import org.example.Models.Inv;
import org.example.Models.Invest;
import org.example.Models.KeyAnalyzers;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.xml.crypto.dsig.keyinfo.KeyName;
import java.time.Month;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

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
        inv.setValue_initial(1000L);
        inv2.setValue_initial(2000L);
        inv.setValue_final(1000L);
        inv2.setValue_final(2000L);

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


    @Test
    public void sumInitValue(){
        assertEquals(3000L, Calc.sumInitValue(hs));
    }

    @Test
    public void sumFinalValue(){
        assertEquals(3000L, Calc.sumFinalValue(hs));
    }

    @Test
    public void multiplyByKey(){
        HashMap<String, Double> hp = Calc.multiplyByKey(hKey, hs);
        assertEquals(300, hp.get("1"));
    }

}