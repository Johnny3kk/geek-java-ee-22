package ru.geekbrains.shop.persist;

import ru.geekbrains.persist.ToDoCategory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Named
@ApplicationScoped
public class BoxingRepository {

    @PersistenceContext(unitName = "ds")
    private EntityManager em;

    public Boxing findById(Long id) {
        return em.find(Boxing.class, id);
    }

    public List<Boxing> findAll() {
        return em.createQuery("from Boxing b", Boxing.class)
                .getResultList();
    }
}
