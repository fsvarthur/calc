package org.example.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.example.models.KeyAnalyzers;

import java.util.List;

@ApplicationScoped
@Transactional
public class KeyAServiceImpl implements KeyAService {
    @PersistenceContext
    private EntityManager em;
    @Override
    public List<KeyAnalyzers> getAllKeysAnalyzers() {
        return em.createQuery("SELECT i FROM KeyAnalyzers i", KeyAnalyzers.class ).getResultList();
    }

    @Override
    public void updateKeyAnalyzer(KeyAnalyzers key, Long Id) {
        em.createQuery("UPDATE Keys SET name=:nm, value=:val WHERE id LIKE :id")
                .setParameter("nm", key.getName()).setParameter("val", key.getValue())
                .setParameter("id", Id);
    }

    @Override
    public void deleteKeyAnalyzer(Long id) {
        em.createQuery("DELETE k FROM Keys k WHERE k.id LIKE :id", KeyAnalyzers.class).setParameter("id",
                id).getResultList();
    }

    @Override
    public void createKeyAnalyzer(KeyAnalyzers key) {
        em.createQuery("INSERT INTO Keys (id, name, value) VALUES (id, name, value)").
                setParameter("id", key.getId()).setParameter("name", key.getName())
                .setParameter("value", key.getValue());
    }

    @Override
    public KeyAnalyzers getKeyAnalyzerById(Long Id) {
        return em.createQuery("SELECT i FROM Keys i WHERE i.id LIKE :id",
                KeyAnalyzers.class).setParameter("id", Id).getSingleResult();
    }
}
