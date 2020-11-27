package ru.geekbrains.shop.persist;

import ru.geekbrains.service.ToDoRepr;
import ru.geekbrains.shop.service.ProductRepr;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class ProductRepositoryImpl implements ProductRepository{

    @PersistenceContext(unitName = "ds")
    private EntityManager em;

    @Override
    public void insert(Product product) {
        em.persist(product);
    }

    @Override
    public void update(Product product) {
        em.merge(product);
    }

    @Override
    public void delete(long id) {
        Product product = em.find(Product.class, id);
        if (product != null) {
            em.remove(product);
        }
    }

    @Override
    public Product findById(Long id) {
       return em.find(Product.class, id);
    }

    @Override
    public List<Product> findAll() {
        return em.createQuery("from Product p", Product.class)
                .getResultList();
    }

    @Override
    public ProductRepr findProductReprById(Long id) {
        return em.createQuery("select new ru.geekbrains.shop.service.ProductRepr(p.id, p.name, p.brand, p.description, p.cost, p.boxing) " +
                "from Product p" +
                " left join p.boxing b " +
                "where p.id = :id", ProductRepr.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public List<ProductRepr> findAllProductRepr() {
        return em.createQuery("select new ru.geekbrains.shop.service.ProductRepr(p.id, p.name, p.brand, p.description, p.cost, p.boxing) " +
                "from Product p" +
                " left join p.boxing b ", ProductRepr.class)
                .getResultList();
    }

}
