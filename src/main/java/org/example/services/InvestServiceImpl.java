package org.example.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.example.models.Invest;
import org.example.models.KeyAnalyzers;
import org.example.models.dto.InvestDTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

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
            logger.log(Level.WARNING, "Not found any investment", ex);
            lis = null;
        }

        return lis;
    }

    @Override
    public InvestDTO getInvestmentById(Long Id) {
        return (InvestDTO) entityManager.createQuery("SELECT invest from Invest i where i.id LIKE :id",
                Invest.class).setParameter("id", Id).getResultList();
    }

    @Override
    public void updateInvestment(Invest invest, Long Id) {
        entityManager.createQuery("UPDATE Invest SET name=:nm, value=:val WHERE id LIKE :id", Invest.class)
                .setParameter("nm", invest.getName()).setParameter("val", invest.getValue())
                .setParameter("id", Id);
    }

    @Override
    public void deleteInvestment(Long Id) {
        entityManager.createQuery("DELETE i FROM Invest I WHERE i.id LIKE :id")
                .setParameter("id", Id);
    }

    @Override
    public void createInvestment(InvestDTO invest) {
        entityManager.createQuery("INSERT INTO Invest(id, name, value) VALUES (:id, :name, :val)")
                .setParameter("id", invest.getId()).setParameter("name", invest.getName())
                .setParameter("val", invest.getValue());
    }

    @Override
    public List<Invest> getInvestmentByMonth(InvestDTO invest) {
        return entityManager.createQuery("SELECT Invest FROM Invest i WHERE i.month_ref LIKE :month",
                Invest.class).setParameter("month", invest.getMonth_ref()).getResultList();
    }
}