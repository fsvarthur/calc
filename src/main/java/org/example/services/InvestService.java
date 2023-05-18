package org.example.services;

import org.example.models.Invest;
import org.example.models.KeyAnalyzers;
import org.example.models.dto.InvestDTO;

import java.util.List;
import java.util.Map;

public interface InvestService {
    List<Invest> getAllInvestments();

    List<Invest> getInvestmentsById(Long Id);

    void updateInvestment(Invest invest, Long Id);
    void deleteInvestment(Long id);
    void createInvestment(Invest invest);
    List<Invest> getInvestmentByMonth(Invest invest);
    Map<Invest, List<Double>> getInvestmentAndKeysByMonth(List<Invest> investList, List<KeyAnalyzers> KAList);
}
