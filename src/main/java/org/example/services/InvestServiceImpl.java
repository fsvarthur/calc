package org.example.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.example.models.Invest;

import java.util.List;

@ApplicationScoped
@Transactional
public class InvestServiceImpl implements InvestService{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Invest> getAllInvestments() {
        return entityManager.createQuery("SELECT i FROM Invest i", Invest.class).getResultList();
    }
}
