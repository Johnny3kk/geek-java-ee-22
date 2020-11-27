package ru.geekbrains.shop.persist;

import ru.geekbrains.shop.service.ProductRepr;

import javax.ejb.Local;
import java.util.List;

@Local
public interface ProductRepository {

    void insert(Product product);

    void update(Product product);

    void delete(long id);

    Product findById(Long id);

    List<Product> findAll();

    ProductRepr findProductReprById(Long id);

    List<ProductRepr> findAllProductRepr();
}
