package org.example.services;

import org.example.models.Invest;
import org.example.models.dto.InvestDTO;

import java.util.List;

public interface InvestService {
    List<Invest> getAllInvestments();
    InvestDTO getInvestment(InvestDTO invest);
}
