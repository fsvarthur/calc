package org.example.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.example.models.Invest;
import org.example.models.KeyAnalyzers;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
        try{
            return entityManager.createQuery("SELECT i FROM Invest i", Invest.class).getResultList();
        }catch (NoResultException ex){
            logger.log(Level.WARNING, "Not found any investment", ex);
        }
        return null;
    }

    @Override
    public List<Invest> getInvestmentsById(Long Id) {
        return entityManager.createQuery("SELECT i FROM Invest i WHERE i.id LIKE :id",
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
        entityManager.createQuery("DELETE i FROM Invest i WHERE i.id LIKE :id")
                .setParameter("id", Id);
    }

    @Override
    public void createInvestment(Invest invest) {
        entityManager.createQuery("INSERT INTO Invest(id, name, value) VALUES (:id, :name, :val)")
                .setParameter("id", invest.getId()).setParameter("name", invest.getName())
                .setParameter("val", invest.getValue());
    }

    @Override
    public List<Invest> getInvestmentByMonth(Invest invest) {
        return entityManager.createQuery("SELECT i FROM Invest i WHERE i.month_ref LIKE :month",
                Invest.class).setParameter("month", invest.getMonth_ref()).getResultList();
    }

    @Override
    public Map<Invest, List<Double>> getInvestmentAndKeysByMonth(List<Invest> investList, List<KeyAnalyzers> KAList) {
        Map<Invest, List<Double>> mapInvestTimesKeys = new HashMap<>();
        investList.stream().map(i ->{
            return KAList.stream().map( ka -> {
                return mapInvestTimesKeys.put(i, Collections.singletonList(i.getValue() * ka.getValue()));
            });
        });
        return mapInvestTimesKeys;
    }
}