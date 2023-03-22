package org.example.Util;

import org.example.Models.Inv;
import org.example.Models.Invest;
import org.example.Models.KeyAnalyzers;

import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public interface Calc {

    public static HashMap<String, Invest> filter(HashMap<String, Invest> hs, Month month){
        HashMap<String, Invest> filtred = new HashMap<>();
        hs.forEach((s, inv) -> {
            if(inv.getMonth_ref() == month)
                filtred.put(s,inv);
        });
        return filtred;
    }

    public static Long sumInitValue(HashMap<String, Invest> hs){
        List<Long> initValue = new ArrayList<>();
        AtomicInteger initVal = new AtomicInteger();
        hs.forEach( (s, inv) -> {
            initValue.add(inv.getValue_initial());
        });
        initValue.forEach( e -> {
            initVal.addAndGet(Math.toIntExact(e));
        });
        return Long.valueOf(String.valueOf(initVal));
    }

    static Long sumFinalValue(HashMap<String, Invest> hs) {
        List<Long> initValue = new ArrayList<>();
        AtomicInteger initVal = new AtomicInteger();
        hs.forEach( (s, inv) -> {
            initValue.add(inv.getValue_final());
        });
        initValue.forEach( e -> {
            initVal.addAndGet(Math.toIntExact(e));
        });
        return Long.valueOf(String.valueOf(initVal));
    }

    static HashMap<String, Double> multiplyByKey(HashMap<String, KeyAnalyzers> hKey,HashMap<String, Invest> hs ){
        HashMap<String, Double> hp = new HashMap<>();
        Long sh = sumInitValue(hs);
        hKey.forEach( (s, keyAnalyzers) -> {
            Double db = percent(keyAnalyzers.getValue()) * sh;
            hp.put("1", db);
        });
        return hp;
    }

    static double percent(double val){
        return val / 100;
    }


}
