package ru.geekbrains.shop.persist;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class BoxingRepositoryImpl implements BoxingRepository{

    @PersistenceContext(unitName = "ds")
    private EntityManager em;

    @Override
    public Boxing findById(Long id) {
        return em.find(Boxing.class, id);
    }

    @Override
    public List<Boxing> findAll() {
        return em.createQuery("from Boxing b", Boxing.class)
                .getResultList();
    }
}
