package org.example.services;

import jakarta.inject.Inject;
import org.example.models.Invest;
import org.example.models.KeyAnalyzers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class InvestServiceTest{
    Invest CDBI = new Invest(1L,"CDB Itau",1000L);
    Invest CDBT = new Invest(1L,"CDB Itau",1000L);
    Invest CDBA = new Invest(1L,"CDB Itau",1000L);
    Invest CDBU = new Invest(1L,"CDB Itau",1000L);
    KeyAnalyzers IPCA = new KeyAnalyzers(1L, "IPCA", 1.0);
    KeyAnalyzers Bovespa = new KeyAnalyzers(2L, "Bovespa", 1.0);
    List<Invest> investList= new ArrayList<>(Arrays.asList(CDBA, CDBI, CDBT,CDBU));
    List<KeyAnalyzers> keyAnalyzersList = new ArrayList<>(Arrays.asList(IPCA,Bovespa));
    @Inject
    InvestService investService;

    @Test
    void getInvestmentAndKeysByMonth(){
        Map<Invest, List<Double>> map = new HashMap<>();
        map.put(CDBI,Arrays.asList(10.0,10.0));
        map.put(CDBA,Arrays.asList(10.0,10.0));
        map.put(CDBT,Arrays.asList(10.0,10.0));
        map.put(CDBU,Arrays.asList(10.0,10.0));
        Assertions.assertEquals(map,investService.getInvestmentAndKeysByMonth(investList,keyAnalyzersList));
    }
}
