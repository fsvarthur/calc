package org.example.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.example.models.Invest;
import org.example.models.dto.InvestDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@ApplicationScoped
@Transactional
public class InvestServiceImpl implements InvestService{

    @Inject
    private Logger logger;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Invest> getAllInvestments() {
        List<Invest> lis = new ArrayList<>();

        try{
            lis.addAll(entityManager.createQuery("SELECT i FROM Invest i", Invest.class).getResultList());
            logger.log(Level.FINE, "Found all programs");
        }catch (NoResultException ex){
            logger.log(Level.FINE, "Not found any investment", ex);
            lis = null;
        }

        return lis;
    }

    @Override
    public InvestDTO getInvestment(InvestDTO invest) {
        return (InvestDTO) entityManager.createQuery("SELECT invest from Invest i where i.name LIKE :invest",
                Invest.class).setParameter("invest", invest.getNome()).getResultList();
    }
}