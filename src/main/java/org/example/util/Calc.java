package org.example.util;

import org.example.models.Invest;

import java.time.Month;
import java.util.HashMap;

public interface Calc {

    public static HashMap<String, Invest> filter(HashMap<String, Invest> hs, Month month){
        HashMap<String, Invest> filtred = new HashMap<>();
        hs.forEach((s, inv) -> {
            if(inv.getMonth_ref() == month)
                filtred.put(s,inv);
        });
        return filtred;
    }

    static double percent(double val){
        return val / 100;
    }


}
